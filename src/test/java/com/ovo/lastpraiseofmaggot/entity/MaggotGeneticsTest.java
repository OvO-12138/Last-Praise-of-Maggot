package com.ovo.lastpraiseofmaggot.entity;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import com.ovo.lastpraiseofmaggot.entity.MaggotGenetics.Genotype;

/** Exhaustive gamete combinations verify exact probabilities, without sampling noise. */
public final class MaggotGeneticsTest {
    private static void cross(Genotype a, Genotype b, int... expected) {
        int[] counts = new int[4];
        for (int first = 0; first < 2; first++) for (int second = 0; second < 2; second++) {
            int[] choices = {first, second};
            AtomicInteger i = new AtomicInteger();
            Genotype child = MaggotGenetics.inherit(a, b, bound -> {
                if (bound != 2) throw new AssertionError("Unequal allele sampling");
                return choices[i.getAndIncrement()];
            });
            if (child.first() != a.allele(first) || child.second() != b.allele(second))
                throw new AssertionError("Offspring did not inherit one allele from each parent");
            counts[child.phenotype().ordinal()]++;
        }
        if (!Arrays.equals(counts, expected)) throw new AssertionError(Arrays.toString(counts));
    }
    public static void main(String[] args) {
        Genotype aa = new Genotype(0,0), ag = new Genotype(0,1), ay = new Genotype(0,2);
        Genotype gg = new Genotype(1,1), yy = new Genotype(2,2), gy = new Genotype(1,2);
        cross(aa, aa, 4,0,0,0);
        cross(ag, ag, 1,3,0,0);
        cross(ay, ay, 1,0,3,0);
        cross(gg, ag, 0,4,0,0);
        cross(yy, ay, 0,0,4,0);
        cross(gg, gg, 0,4,0,0);
        cross(yy, yy, 0,0,4,0);
        cross(gg, aa, 0,4,0,0);
        cross(gy, gy, 0,1,1,2);
        // Every non-rainbow mating gets precisely one winning roll out of 1000.
        for (Genotype parent : new Genotype[]{aa, ag, ay, gg, yy}) {
            int mutations = 0;
            for (int roll=0; roll<1000; roll++) {
                final int draw=roll;
                AtomicInteger calls = new AtomicInteger();
                Genotype normal= new Genotype(parent.first(), parent.first());
                Genotype child=MaggotGenetics.offspring(parent,parent,false,bound -> {
                    if (bound==2) return 0;
                    if (bound!=1000) throw new AssertionError("Wrong mutation denominator");
                    calls.incrementAndGet();
                    return draw;
                });
                if (calls.get()!=1) throw new AssertionError("Not one independent mutation draw");
                if (draw==0) {
                    if (!child.equals(gy)) throw new AssertionError("Mutation has wrong genes");
                    mutations++;
                } else if (!child.equals(normal)) throw new AssertionError("Non-mutated inheritance changed");
            }
            if (mutations!=1) throw new AssertionError("Mutation rate is not 0.1%");
        }
        // Rainbow matings keep their original inheritance and never draw a mutation roll.
        for (Genotype partner : new Genotype[]{aa, gy}) {
            for(int first=0;first<2;first++) for(int second=0;second<2;second++) {
                int[] choices={first,second};AtomicInteger calls=new AtomicInteger();
                Genotype child=MaggotGenetics.offspring(gy,partner,true,bound -> {
                    if(bound!=2) throw new AssertionError("Rainbow parent triggered mutation");
                    return choices[calls.getAndIncrement()];
                });
                if(!child.equals(new Genotype(gy.allele(first),partner.allele(second))))
                    throw new AssertionError("Rainbow inheritance changed");
            }
        }
        for (int allele=0; allele<3; allele++)
            if (!MaggotGenetics.treatBasic(allele).equals(new Genotype(0,allele)))
                throw new AssertionError("Germline treatment");
        try { new Genotype(3,0); throw new AssertionError("Invalid allele accepted"); }
        catch (IllegalArgumentException expected) {}
        System.out.println("PASS: 9 Mendelian crosses, 5000 mutation rolls, unchanged rainbow inheritance and gene treatments");
    }
}

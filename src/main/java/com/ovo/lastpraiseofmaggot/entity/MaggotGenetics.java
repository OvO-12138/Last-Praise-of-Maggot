package com.ovo.lastpraiseofmaggot.entity;

import java.util.function.IntUnaryOperator;

/** Diploid germline colour locus. g/y dominate A; g/y together are codominant. */
public final class MaggotGenetics {
    public static final int BASIC = 0;
    public static final int GOLD = 1;
    public static final int YELLOW_PURPLE = 2;

    public record Genotype(int first, int second) {
        public Genotype {
            if (first < BASIC || first > YELLOW_PURPLE || second < BASIC || second > YELLOW_PURPLE)
                throw new IllegalArgumentException("Unknown maggot allele");
        }
        public int allele(int gamete) { return gamete == 0 ? first : second; }
        public Phenotype phenotype() {
            if (first == BASIC && second == BASIC) return Phenotype.BASIC;
            if ((first == GOLD && second == YELLOW_PURPLE) || (first == YELLOW_PURPLE && second == GOLD))
                return Phenotype.RAINBOW;
            if (first == GOLD || second == GOLD) return Phenotype.GOLD;
            return Phenotype.YELLOW_PURPLE;
        }
    }
    public enum Phenotype { BASIC, GOLD, YELLOW_PURPLE, RAINBOW }
    private MaggotGenetics() {}
    public static Genotype inherit(Genotype firstParent, Genotype secondParent, IntUnaryOperator random) {
        return new Genotype(firstParent.allele(random.applyAsInt(2)), secondParent.allele(random.applyAsInt(2)));
    }
    /** One independent 1-in-1000 mutation draw, only when neither parent is rainbow. */
    public static Genotype offspring(Genotype firstParent, Genotype secondParent,
                                     boolean rainbowParent, IntUnaryOperator random) {
        Genotype child = inherit(firstParent, secondParent, random);
        if (!rainbowParent && random.applyAsInt(1000) == 0)
            return new Genotype(GOLD, YELLOW_PURPLE);
        return child;
    }
    /** Game-specific germline treatment; it does not recolour the parent's body. */
    public static Genotype treatBasic(int foodAllele) { return new Genotype(BASIC, foodAllele); }
}

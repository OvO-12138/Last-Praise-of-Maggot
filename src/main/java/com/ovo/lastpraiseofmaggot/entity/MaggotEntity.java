package com.ovo.lastpraiseofmaggot.entity;

import com.ovo.lastpraiseofmaggot.registry.ModEntities;
import com.ovo.lastpraiseofmaggot.registry.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MaggotEntity extends Animal {
    public static final float MAGGOT_MAX_HEALTH = 100000.0F;
    public static final int GROWTH_TICKS = 10 * 60 * 20;
    public static final int FEED_GROWTH_TICKS = 20 * 20;
    private MaggotGenetics.Genotype genes;
    private Boolean sisterLineage;
    private int breedingFood;

    public MaggotEntity(EntityType<? extends MaggotEntity> type, Level level) {
        super(type, level);
        this.setHealth(MAGGOT_MAX_HEALTH);
        this.setPersistenceRequired();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, MAGGOT_MAX_HEALTH)
                .add(Attributes.MOVEMENT_SPEED, 0.13D)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.85D);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D, MaggotEntity.class));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.55D, 35));
    }
    public MaggotGenetics.Phenotype colour() {
        EntityType<?> type = getType();
        if (type == ModEntities.PURE_GOLD_MAGGOT.get() || type == ModEntities.BABY_PURE_GOLD_MAGGOT.get())
            return MaggotGenetics.Phenotype.GOLD;
        if (type == ModEntities.YELLOW_PURPLE_MAGGOT.get() || type == ModEntities.BABY_YELLOW_PURPLE_MAGGOT.get())
            return MaggotGenetics.Phenotype.YELLOW_PURPLE;
        if (type == ModEntities.RAINBOW_MAGGOT.get() || type == ModEntities.BABY_RAINBOW_MAGGOT.get())
            return MaggotGenetics.Phenotype.RAINBOW;
        return MaggotGenetics.Phenotype.BASIC;
    }
    public boolean hasSisterLineage() {
        if (sisterLineage == null) sisterLineage = getType() == ModEntities.SISTER_MAGGOT.get()
                || getType() == ModEntities.BABY_SISTER_MAGGOT.get();
        return sisterLineage;
    }
    public MaggotGenetics.Genotype getGenes() {
        if (genes == null) genes = switch (colour()) {
            case GOLD -> new MaggotGenetics.Genotype(MaggotGenetics.BASIC, MaggotGenetics.GOLD);
            case YELLOW_PURPLE -> new MaggotGenetics.Genotype(MaggotGenetics.BASIC, MaggotGenetics.YELLOW_PURPLE);
            case RAINBOW -> new MaggotGenetics.Genotype(MaggotGenetics.GOLD, MaggotGenetics.YELLOW_PURPLE);
            case BASIC -> new MaggotGenetics.Genotype(MaggotGenetics.BASIC, MaggotGenetics.BASIC);
        };
        return genes;
    }
    private static int foodKind(ItemStack stack) {
        if (stack.is(ModItems.HONKAI_CHICKEN_POOP.get())) return 1;
        if (stack.is(ModItems.GOLDEN_CHICKEN_POOP.get())) return 2;
        if (stack.is(ModItems.YELLOW_PURPLE_CHICKEN_POOP.get())) return 3;
        return 0;
    }
    private boolean acceptsFood(int food) {
        return switch (colour()) {
            case BASIC -> isBaby() ? food == 1 : food >= 1 && food <= 3;
            case GOLD -> food == 2;
            case YELLOW_PURPLE -> food == 3;
            case RAINBOW -> food == 1;
        };
    }
    @Override
    public boolean isFood(ItemStack stack) { return acceptsFood(foodKind(stack)); }
    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        int food = foodKind(stack);
        if (stack.isEmpty() && player.isShiftKeyDown()) {
            if (!level().isClientSide) {
                String[] symbols = {"A", "G", "Y"};
                player.displayClientMessage(net.minecraft.network.chat.Component.translatable(
                        "message.lastpraiseofmaggot.genetics", symbols[getGenes().first()], symbols[getGenes().second()],
                        Math.max(0, (-getAge() + 19) / 20)), true);
            }
            return InteractionResult.sidedSuccess(level().isClientSide);
        }
        if (!acceptsFood(food)) return super.mobInteract(player, hand);
        if (isBaby()) {
            if (!level().isClientSide) {
                usePlayerItem(player, hand, stack);
                setAge(Math.min(0, getAge() + FEED_GROWTH_TICKS));
                ((ServerLevel) level()).sendParticles(net.minecraft.core.particles.ParticleTypes.HAPPY_VILLAGER,
                        getX(), getY() + 0.5D, getZ(), 7, 0.3D, 0.15D, 0.3D, 0.0D);
            }
            return InteractionResult.sidedSuccess(level().isClientSide);
        }
        if (level().isClientSide) return InteractionResult.SUCCESS;
        if (getAge() != 0 || !canFallInLove()) return InteractionResult.PASS;
        if (!level().isClientSide) {
            if (colour() == MaggotGenetics.Phenotype.BASIC) genes = MaggotGenetics.treatBasic(food - 1);
            breedingFood = food;
            usePlayerItem(player, hand, stack);
            setInLove(player);
        }
        return InteractionResult.sidedSuccess(level().isClientSide);
    }
    @Override
    public boolean canMate(Animal other) {
        return other instanceof MaggotEntity mate && mate != this && isAlive() && mate.isAlive()
                && getAge() == 0 && mate.getAge() == 0 && isInLove() && mate.isInLove()
                && breedingFood != 0 && breedingFood == mate.breedingFood
                && acceptsFood(breedingFood) && mate.acceptsFood(breedingFood);
    }
    @Override
    public MaggotEntity getBreedOffspring(ServerLevel level, AgeableMob other) {
        if (!(other instanceof MaggotEntity mate) || !canMate(mate)) return null;
        MaggotGenetics.Genotype inherited = MaggotGenetics.offspring(getGenes(), mate.getGenes(),
                colour() == MaggotGenetics.Phenotype.RAINBOW || mate.colour() == MaggotGenetics.Phenotype.RAINBOW,
                random::nextInt);
        boolean sister = random.nextBoolean() ? hasSisterLineage() : mate.hasSisterLineage();
        EntityType<? extends MaggotEntity> type = switch (inherited.phenotype()) {
            case GOLD -> ModEntities.BABY_PURE_GOLD_MAGGOT.get();
            case YELLOW_PURPLE -> ModEntities.BABY_YELLOW_PURPLE_MAGGOT.get();
            case RAINBOW -> ModEntities.BABY_RAINBOW_MAGGOT.get();
            case BASIC -> sister ? ModEntities.BABY_SISTER_MAGGOT.get() : ModEntities.BABY_BROTHER_MAGGOT.get();
        };
        MaggotEntity child = type.create(level);
        if (child != null) {
            child.genes = inherited;
            child.sisterLineage = sister;
            child.setAge(-GROWTH_TICKS);
        }
        return child;
    }
    @Override
    public void spawnChildFromBreeding(ServerLevel level, Animal other) {
        // Both parents' goals can run in one tick; recheck before producing another child.
        if (canMate(other)) super.spawnChildFromBreeding(level, other);
    }
    @Override
    public void finalizeSpawnChildFromBreeding(ServerLevel level, Animal other, AgeableMob child) {
        if (child instanceof MaggotEntity) child.setAge(-GROWTH_TICKS);
        super.finalizeSpawnChildFromBreeding(level, other, child);
    }
    @Override
    public void setBaby(boolean baby) { setAge(baby ? -GROWTH_TICKS : 0); }
    @Override
    public void resetLove() { super.resetLove(); breedingFood = 0; }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("MaggotAllele1", getGenes().first());
        tag.putInt("MaggotAllele2", getGenes().second());
        tag.putBoolean("MaggotSisterLineage", hasSisterLineage());
        tag.putInt("MaggotBreedingFood", breedingFood);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        genes = null;
        if (tag.contains("MaggotAllele1") && tag.contains("MaggotAllele2")) {
            try {
                MaggotGenetics.Genotype saved = new MaggotGenetics.Genotype(tag.getInt("MaggotAllele1"), tag.getInt("MaggotAllele2"));
                // Basic bodies can have treated germline cells without expressing their colour.
                if (saved.phenotype() == colour() || (colour() == MaggotGenetics.Phenotype.BASIC
                        && (saved.first() == MaggotGenetics.BASIC || saved.second() == MaggotGenetics.BASIC))) genes = saved;
            } catch (IllegalArgumentException ignored) {
                // Old or malformed saves retain the entity type's default genotype.
            }
        }
        sisterLineage = tag.contains("MaggotSisterLineage") ? tag.getBoolean("MaggotSisterLineage") : null;
        breedingFood = tag.getInt("MaggotBreedingFood");
        if (!acceptsFood(breedingFood) || !isInLove()) breedingFood = 0;
    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) { return false; }
    @Override
    public boolean causeFallDamage(float distance, float damageMultiplier, net.minecraft.world.damagesource.DamageSource source) {
        return false;
    }
}

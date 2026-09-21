package com.ovo.lastpraiseofmaggot.entity;

import com.ovo.lastpraiseofmaggot.registry.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/** Juvenile registry entries mature into the matching adult registry entry. */
public final class BabyMaggotEntity extends MaggotEntity {
    public BabyMaggotEntity(EntityType<? extends MaggotEntity> type, Level level) {
        super(type, level);
        setAge(-GROWTH_TICKS);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        // Permanent juveniles from earlier builds have no Age field.
        if (!tag.contains("Age")) setAge(-GROWTH_TICKS);
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (level() instanceof ServerLevel server && isAlive() && !isRemoved() && getAge() >= 0) {
            EntityType<? extends MaggotEntity> adultType = switch (colour()) {
                case GOLD -> ModEntities.PURE_GOLD_MAGGOT.get();
                case YELLOW_PURPLE -> ModEntities.YELLOW_PURPLE_MAGGOT.get();
                case RAINBOW -> ModEntities.RAINBOW_MAGGOT.get();
                case BASIC -> hasSisterLineage() ? ModEntities.SISTER_MAGGOT.get() : ModEntities.BROTHER_MAGGOT.get();
            };
            MaggotEntity adult = adultType.create(server);
            if (adult == null || isPassenger() || isVehicle()) return;
            CompoundTag saved = new CompoundTag();
            saveWithoutId(saved);
            adult.load(saved);
            // Remove first so the original UUID can be reused by the adult.
            discard();
            server.addFreshEntity(adult);
        }
    }
}

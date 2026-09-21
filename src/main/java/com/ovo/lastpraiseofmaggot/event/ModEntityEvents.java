package com.ovo.lastpraiseofmaggot.event;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import com.ovo.lastpraiseofmaggot.entity.MaggotEntity;
import com.ovo.lastpraiseofmaggot.mixin.RangedAttributeAccessor;
import com.ovo.lastpraiseofmaggot.registry.ModEntities;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import com.ovo.lastpraiseofmaggot.entity.YellowPurpleFishEntity;
import com.ovo.lastpraiseofmaggot.entity.YellowPurpleAxolotlEntity;
import com.ovo.lastpraiseofmaggot.entity.YellowPurpleBabyAxolotlEntity;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = LastPraiseOfMaggot.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEntityEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        RangedAttribute maxHealth = (RangedAttribute) Attributes.MAX_HEALTH;
        if (maxHealth.getMaxValue() < MaggotEntity.MAGGOT_MAX_HEALTH) {
            ((RangedAttributeAccessor) (Object) maxHealth)
                    .lastpraiseofmaggot$setMaxValue(MaggotEntity.MAGGOT_MAX_HEALTH);
        }

        event.put(ModEntities.BROTHER_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.SISTER_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.RAINBOW_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.PURE_GOLD_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.YELLOW_PURPLE_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.BABY_BROTHER_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.BABY_SISTER_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.BABY_RAINBOW_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.BABY_PURE_GOLD_MAGGOT.get(), MaggotEntity.createAttributes().build());
        event.put(ModEntities.BABY_YELLOW_PURPLE_MAGGOT.get(), MaggotEntity.createAttributes().build());

        event.put(ModEntities.YELLOW_PURPLE_LITTLE_FISH.get(), YellowPurpleFishEntity.createAttributes().build());
        event.put(ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL.get(), YellowPurpleAxolotlEntity.createAttributes().build());
        event.put(ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL_BABY.get(), YellowPurpleBabyAxolotlEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(
                ModEntities.YELLOW_PURPLE_LITTLE_FISH.get(),
                SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                YellowPurpleFishEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
        event.register(
                ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL.get(),
                SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                YellowPurpleAxolotlEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
        event.register(
                ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL_BABY.get(),
                SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                YellowPurpleAxolotlEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.REPLACE
        );
    }
}

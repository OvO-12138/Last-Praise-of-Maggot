package com.ovo.lastpraiseofmaggot.registry;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import com.ovo.lastpraiseofmaggot.entity.MaggotEntity;
import com.ovo.lastpraiseofmaggot.entity.BabyMaggotEntity;
import com.ovo.lastpraiseofmaggot.entity.YellowPurpleFishEntity;
import com.ovo.lastpraiseofmaggot.entity.YellowPurpleAxolotlEntity;
import com.ovo.lastpraiseofmaggot.entity.YellowPurpleBabyAxolotlEntity;
import com.ovo.lastpraiseofmaggot.entity.BrotherMaggotSpitEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.*;
public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, LastPraiseOfMaggot.MODID);
    public static final RegistryObject<EntityType<MaggotEntity>> BROTHER_MAGGOT =
            ENTITY_TYPES.register("brother_maggot",
                    () -> EntityType.Builder.of(MaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("brother_maggot"));

    public static final RegistryObject<EntityType<MaggotEntity>> SISTER_MAGGOT =
            ENTITY_TYPES.register("sister_maggot",
                    () -> EntityType.Builder.of(MaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.35F, 0.57F)
                            .clientTrackingRange(10)
                            .build("sister_maggot"));

    public static final RegistryObject<EntityType<MaggotEntity>> RAINBOW_MAGGOT =
            ENTITY_TYPES.register("rainbow_maggot",
                    () -> EntityType.Builder.of(MaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("rainbow_maggot"));

    public static final RegistryObject<EntityType<MaggotEntity>> PURE_GOLD_MAGGOT =
            ENTITY_TYPES.register("pure_gold_maggot",
                    () -> EntityType.Builder.of(MaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("pure_gold_maggot"));

    public static final RegistryObject<EntityType<BrotherMaggotSpitEntity>> BROTHER_MAGGOT_SPIT =
            ENTITY_TYPES.register("brother_maggot_spit",
                    () -> EntityType.Builder.<BrotherMaggotSpitEntity>of(BrotherMaggotSpitEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(8)
                            .updateInterval(10)
                            .build("brother_maggot_spit"));

    public static final RegistryObject<EntityType<YellowPurpleFishEntity>> YELLOW_PURPLE_LITTLE_FISH =
            ENTITY_TYPES.register("yellow_purple_little_fish",
                    () -> EntityType.Builder.of(
                                    YellowPurpleFishEntity::new,
                                    MobCategory.WATER_AMBIENT
                            )
                            .sized(0.7F, 0.4F)
                            .clientTrackingRange(4)
                            .updateInterval(3)
                            .build("yellow_purple_little_fish"));
    public static final RegistryObject<EntityType<YellowPurpleAxolotlEntity>> YELLOW_PURPLE_LITTLE_AXOLOTL =
            ENTITY_TYPES.register("yellow_purple_little_axolotl",
                    () -> EntityType.Builder.of(
                                    YellowPurpleAxolotlEntity::new,
                                    MobCategory.AXOLOTLS
                            )
                            .sized(0.75F, 0.42F)
                            .clientTrackingRange(8)
                            .updateInterval(3)
                            .build("yellow_purple_little_axolotl"));
    public static final RegistryObject<EntityType<YellowPurpleBabyAxolotlEntity>> YELLOW_PURPLE_LITTLE_AXOLOTL_BABY =
            ENTITY_TYPES.register("yellow_purple_little_axolotl_baby",
                    () -> EntityType.Builder.of(
                                    YellowPurpleBabyAxolotlEntity::new,
                                    MobCategory.AXOLOTLS
                            )
                            .sized(0.42F, 0.24F)
                            .clientTrackingRange(8)
                            .updateInterval(3)
                            .build("yellow_purple_little_axolotl_baby"));
    public static final RegistryObject<EntityType<MaggotEntity>> YELLOW_PURPLE_MAGGOT =
            ENTITY_TYPES.register("yellow_purple_maggot",
                    () -> EntityType.Builder.of(MaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("yellow_purple_maggot"));
    public static final RegistryObject<EntityType<BabyMaggotEntity>> BABY_BROTHER_MAGGOT =
            ENTITY_TYPES.register("baby_brother_maggot",
                    () -> EntityType.Builder.of(BabyMaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("baby_brother_maggot"));

    public static final RegistryObject<EntityType<BabyMaggotEntity>> BABY_SISTER_MAGGOT =
            ENTITY_TYPES.register("baby_sister_maggot",
                    () -> EntityType.Builder.of(BabyMaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.35F, 0.57F)
                            .clientTrackingRange(10)
                            .build("baby_sister_maggot"));

    public static final RegistryObject<EntityType<BabyMaggotEntity>> BABY_RAINBOW_MAGGOT =
            ENTITY_TYPES.register("baby_rainbow_maggot",
                    () -> EntityType.Builder.of(BabyMaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("baby_rainbow_maggot"));

    public static final RegistryObject<EntityType<BabyMaggotEntity>> BABY_PURE_GOLD_MAGGOT =
            ENTITY_TYPES.register("baby_pure_gold_maggot",
                    () -> EntityType.Builder.of(BabyMaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("baby_pure_gold_maggot"));

    public static final RegistryObject<EntityType<BabyMaggotEntity>> BABY_YELLOW_PURPLE_MAGGOT =
            ENTITY_TYPES.register("baby_yellow_purple_maggot",
                    () -> EntityType.Builder.of(BabyMaggotEntity::new, MobCategory.CREATURE)
                            .sized(1.55F, 0.65F)
                            .clientTrackingRange(10)
                            .build("baby_yellow_purple_maggot"));

}

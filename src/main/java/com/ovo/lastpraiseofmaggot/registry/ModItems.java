package com.ovo.lastpraiseofmaggot.registry;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import com.ovo.lastpraiseofmaggot.item.NamelessTownChestplateItem;
import com.ovo.lastpraiseofmaggot.item.YellowPurpleLittleBedItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.*;
public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LastPraiseOfMaggot.MODID);
    public static final RegistryObject<Item> BROTHER_MAGGOT_SPAWN_EGG =
            ITEMS.register("brother_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.BROTHER_MAGGOT,
                            0x7020A8,
                            0xD796FF,
                            new Item.Properties()
                    ));
    public static final RegistryObject<Item> SISTER_MAGGOT_SPAWN_EGG =
            ITEMS.register("sister_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.SISTER_MAGGOT,
                            0xD9348B,
                            0xFFD0E8,
                            new Item.Properties()
                    ));
    public static final RegistryObject<Item> RAINBOW_MAGGOT_SPAWN_EGG =
            ITEMS.register("rainbow_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.RAINBOW_MAGGOT,
                            0xFF3B66,
                            0x35D9FF,
                            new Item.Properties()
                    ));
    public static final RegistryObject<Item> PURE_GOLD_MAGGOT_SPAWN_EGG =
            ITEMS.register("pure_gold_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.PURE_GOLD_MAGGOT,
                            0xFFD700,
                            0xB87900,
                            new Item.Properties()
                    ));
    public static final RegistryObject<Item> MAGGOT_CARE_BOOK =
            ITEMS.register("maggot_care_book", () -> new com.ovo.lastpraiseofmaggot.item.MaggotCareBookItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> HONKAI_CHICKEN_POOP =
            ITEMS.register("honkai_chicken_poop", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> GOLDEN_CHICKEN_POOP =
            ITEMS.register("golden_chicken_poop", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> YELLOW_PURPLE_CHICKEN_POOP =
            ITEMS.register("yellow_purple_chicken_poop", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> CHICKEN_POOP =
            ITEMS.register("chicken_poop", () -> new Item(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> BROTHER_MAGGOT_SPIT =
            ITEMS.register("brother_maggot_spit",
                    () -> new Item(
                            new Item.Properties()
                                    .stacksTo(1)
                    ));
    public static final RegistryObject<Item> NAMELESS_TOWN_CHESTPLATE =
            ITEMS.register("nameless_town_chestplate",
                    () -> new NamelessTownChestplateItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> YELLOW_PURPLE_LITTLE_FISH_SPAWN_EGG =
            ITEMS.register(
                    "yellow_purple_little_fish_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.YELLOW_PURPLE_LITTLE_FISH,
                            0xF0EA19,
                            0x8A13D4,
                            new Item.Properties()
                    )
            );
    public static final RegistryObject<Item> YELLOW_PURPLE_LITTLE_AXOLOTL_SPAWN_EGG =
            ITEMS.register(
                    "yellow_purple_little_axolotl_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL,
                            0xF0EA19,
                            0x8A13D4,
                            new Item.Properties()
                    )
            );
    public static final RegistryObject<Item> YELLOW_PURPLE_LITTLE_AXOLOTL_BABY_SPAWN_EGG =
            ITEMS.register(
                    "yellow_purple_little_axolotl_baby_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL_BABY,
                            0x8A13D4,
                            0xF0EA19,
                            new Item.Properties()
                    )
            );
    public static final RegistryObject<Item> YELLOW_PURPLE_DYE =
            ITEMS.register(
                    "yellow_purple_dye",
                    () -> new Item(new Item.Properties().stacksTo(64))
            );
    public static final RegistryObject<Item> YELLOW_PURPLE_WOOL =
            ITEMS.register(
                    "yellow_purple_wool",
                    () -> new BlockItem(
                            ModBlock.YELLOW_PURPLE_WOOL.get(),
                            new Item.Properties()
                    )
            );
    public static final RegistryObject<Item> YELLOW_PURPLE_LITTLE_BED =
            ITEMS.register(
                    "yellow_purple_little_bed",
                    () -> new YellowPurpleLittleBedItem(
                            ModBlock.YELLOW_PURPLE_LITTLE_BED.get(),
                            new Item.Properties().stacksTo(1)
                    )
            );
    public static final RegistryObject<Item> YELLOW_PURPLE_MAGGOT_SPAWN_EGG =
            ITEMS.register("yellow_purple_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.YELLOW_PURPLE_MAGGOT, 0xF0EA19, 0x8A13D4, new Item.Properties()));
    public static final RegistryObject<Item> BABY_BROTHER_MAGGOT_SPAWN_EGG =
            ITEMS.register("baby_brother_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.BABY_BROTHER_MAGGOT,
                            0x7020A8, 0xF2DCFF, new Item.Properties()));

    public static final RegistryObject<Item> BABY_SISTER_MAGGOT_SPAWN_EGG =
            ITEMS.register("baby_sister_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.BABY_SISTER_MAGGOT,
                            0xD9348B, 0xFFE6F2, new Item.Properties()));

    public static final RegistryObject<Item> BABY_RAINBOW_MAGGOT_SPAWN_EGG =
            ITEMS.register("baby_rainbow_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.BABY_RAINBOW_MAGGOT,
                            0xFF3B66, 0xB1F1FF, new Item.Properties()));

    public static final RegistryObject<Item> BABY_PURE_GOLD_MAGGOT_SPAWN_EGG =
            ITEMS.register("baby_pure_gold_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.BABY_PURE_GOLD_MAGGOT,
                            0xFFD700, 0xFFF2B3, new Item.Properties()));

    public static final RegistryObject<Item> BABY_YELLOW_PURPLE_MAGGOT_SPAWN_EGG =
            ITEMS.register("baby_yellow_purple_maggot_spawn_egg",
                    () -> new ForgeSpawnEggItem(
                            ModEntities.BABY_YELLOW_PURPLE_MAGGOT,
                            0xF0EA19, 0xC58AFF, new Item.Properties()));

}

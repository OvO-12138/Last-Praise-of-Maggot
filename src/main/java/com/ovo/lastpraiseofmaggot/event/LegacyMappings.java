package com.ovo.lastpraiseofmaggot.event;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import com.ovo.lastpraiseofmaggot.registry.ModEntities;
import com.ovo.lastpraiseofmaggot.registry.ModItems;
import com.ovo.lastpraiseofmaggot.registry.ModBlock;
import com.ovo.lastpraiseofmaggot.registry.ModBlockEntities;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
@Mod.EventBusSubscriber(modid = LastPraiseOfMaggot.MODID)
public final class LegacyMappings {
    @SubscribeEvent
    public static void remap(MissingMappingsEvent event) {
        for (var mapping : event.getMappings(ForgeRegistries.Keys.ENTITY_TYPES, "lastsongofelysian")) {
            switch (mapping.getKey().getPath()) {
                case "qu_ge" -> mapping.remap(ModEntities.BROTHER_MAGGOT.get());
                case "qu_jie" -> mapping.remap(ModEntities.SISTER_MAGGOT.get());
                case "qu_ge_spit" -> mapping.remap(ModEntities.BROTHER_MAGGOT_SPIT.get());
                case "yellow_purple_little_fish" -> mapping.remap(ModEntities.YELLOW_PURPLE_LITTLE_FISH.get());
                case "yellow_purple_little_axolotl", "yellow_purple_axolotl" -> mapping.remap(ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL.get());
                case "yellow_purple_little_axolotl_baby", "yellow_purple_baby_axolotl" -> mapping.remap(ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL_BABY.get());
            }
        }
        for (var mapping : event.getMappings(ForgeRegistries.Keys.ITEMS, "lastsongofelysian")) {
            switch (mapping.getKey().getPath()) {
                case "qu_ge_spawn_egg" -> mapping.remap(ModItems.BROTHER_MAGGOT_SPAWN_EGG.get());
                case "qu_jie_spawn_egg" -> mapping.remap(ModItems.SISTER_MAGGOT_SPAWN_EGG.get());
                case "qu_ge_spit" -> mapping.remap(ModItems.BROTHER_MAGGOT_SPIT.get());
                case "yellow_purple_little_fish_spawn_egg" -> mapping.remap(ModItems.YELLOW_PURPLE_LITTLE_FISH_SPAWN_EGG.get());
                case "yellow_purple_little_axolotl_spawn_egg", "yellow_purple_axolotl_spawn_egg" -> mapping.remap(ModItems.YELLOW_PURPLE_LITTLE_AXOLOTL_SPAWN_EGG.get());
                case "yellow_purple_little_axolotl_baby_spawn_egg", "yellow_purple_baby_axolotl_spawn_egg" -> mapping.remap(ModItems.YELLOW_PURPLE_LITTLE_AXOLOTL_BABY_SPAWN_EGG.get());
                case "yellow_purple_dye" -> mapping.remap(ModItems.YELLOW_PURPLE_DYE.get());
                case "yellow_purple_wool" -> mapping.remap(ModItems.YELLOW_PURPLE_WOOL.get());
                case "yellow_purple_little_bed" -> mapping.remap(ModItems.YELLOW_PURPLE_LITTLE_BED.get());
                case "nameless_town_chestplate" -> mapping.remap(ModItems.NAMELESS_TOWN_CHESTPLATE.get());
            }
        }
        for (var mapping : event.getMappings(ForgeRegistries.Keys.BLOCKS, "lastsongofelysian")) {
            switch (mapping.getKey().getPath()) {
                case "yellow_purple_wool" -> mapping.remap(ModBlock.YELLOW_PURPLE_WOOL.get());
                case "yellow_purple_little_bed" -> mapping.remap(ModBlock.YELLOW_PURPLE_LITTLE_BED.get());
            }
        }
        for (var mapping : event.getMappings(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, "lastsongofelysian")) {
            if (mapping.getKey().getPath().equals("yellow_purple_little_bed")) {
                mapping.remap(ModBlockEntities.YELLOW_PURPLE_LITTLE_BED.get());
            }
        }
    }
}

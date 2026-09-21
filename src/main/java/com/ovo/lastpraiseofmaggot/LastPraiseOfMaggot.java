package com.ovo.lastpraiseofmaggot;
import com.ovo.lastpraiseofmaggot.registry.ModEntities;
import com.ovo.lastpraiseofmaggot.registry.ModItems;
import com.ovo.lastpraiseofmaggot.registry.ModBlock;
import com.ovo.lastpraiseofmaggot.registry.ModBlockEntities;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
@Mod(LastPraiseOfMaggot.MODID)
public final class LastPraiseOfMaggot {
    public static final String MODID = "lastpraiseofmaggot";
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> MAGGOT_TAB = TABS.register("maggots", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.lastpraiseofmaggot"))
            .icon(() -> ModItems.BROTHER_MAGGOT_SPAWN_EGG.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.BROTHER_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.BABY_BROTHER_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.SISTER_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.BABY_SISTER_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.RAINBOW_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.BABY_RAINBOW_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.PURE_GOLD_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.BABY_PURE_GOLD_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.YELLOW_PURPLE_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.BABY_YELLOW_PURPLE_MAGGOT_SPAWN_EGG.get());
                output.accept(ModItems.YELLOW_PURPLE_LITTLE_FISH_SPAWN_EGG.get());
                output.accept(ModItems.YELLOW_PURPLE_LITTLE_AXOLOTL_SPAWN_EGG.get());
                output.accept(ModItems.YELLOW_PURPLE_LITTLE_AXOLOTL_BABY_SPAWN_EGG.get());
                output.accept(ModItems.YELLOW_PURPLE_DYE.get());
                output.accept(ModItems.YELLOW_PURPLE_WOOL.get());
                output.accept(ModItems.YELLOW_PURPLE_LITTLE_BED.get());
                output.accept(ModItems.NAMELESS_TOWN_CHESTPLATE.get());
                output.accept(ModItems.BROTHER_MAGGOT_SPIT.get());
                output.accept(ModItems.CHICKEN_POOP.get());
                output.accept(ModItems.HONKAI_CHICKEN_POOP.get());
                output.accept(ModItems.GOLDEN_CHICKEN_POOP.get());
                output.accept(ModItems.YELLOW_PURPLE_CHICKEN_POOP.get());
                output.accept(ModItems.MAGGOT_CARE_BOOK.get());
            }).build());
    public LastPraiseOfMaggot() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITY_TYPES.register(bus);
        ModBlock.BLOCKS.register(bus);
        ModBlockEntities.BLOCK_ENTITY_TYPES.register(bus);
        ModItems.ITEMS.register(bus);
        TABS.register(bus);
    }
}

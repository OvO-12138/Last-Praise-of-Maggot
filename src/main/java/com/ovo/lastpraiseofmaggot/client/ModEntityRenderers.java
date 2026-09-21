package com.ovo.lastpraiseofmaggot.client;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import com.ovo.lastpraiseofmaggot.client.model.MaggotModel;
import com.ovo.lastpraiseofmaggot.client.renderer.MaggotRenderer;
import com.ovo.lastpraiseofmaggot.client.renderer.YellowPurpleFishRenderer;
import com.ovo.lastpraiseofmaggot.client.renderer.YellowPurpleAxolotlRenderer;
import com.ovo.lastpraiseofmaggot.client.renderer.YellowPurpleBabyAxolotlRenderer;
import com.ovo.lastpraiseofmaggot.registry.ModEntities;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = LastPraiseOfMaggot.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ModEntityRenderers {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MaggotModel.LAYER_LOCATION, MaggotModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.BROTHER_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.SISTER_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.RAINBOW_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.PURE_GOLD_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.YELLOW_PURPLE_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.BABY_BROTHER_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.BABY_SISTER_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.BABY_RAINBOW_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.BABY_PURE_GOLD_MAGGOT.get(), MaggotRenderer::new);
        event.registerEntityRenderer(ModEntities.BABY_YELLOW_PURPLE_MAGGOT.get(), MaggotRenderer::new);

        event.registerEntityRenderer(ModEntities.BROTHER_MAGGOT_SPIT.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(
                ModEntities.YELLOW_PURPLE_LITTLE_FISH.get(),
                YellowPurpleFishRenderer::new
        );
        event.registerEntityRenderer(
                ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL.get(),
                YellowPurpleAxolotlRenderer::new
        );
        event.registerEntityRenderer(
                ModEntities.YELLOW_PURPLE_LITTLE_AXOLOTL_BABY.get(),
                YellowPurpleBabyAxolotlRenderer::new
        );
    }
}

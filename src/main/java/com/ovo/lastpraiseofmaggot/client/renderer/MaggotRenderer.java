package com.ovo.lastpraiseofmaggot.client.renderer;

import com.ovo.lastpraiseofmaggot.client.model.MaggotModel;
import com.ovo.lastpraiseofmaggot.entity.MaggotEntity;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import com.ovo.lastpraiseofmaggot.registry.ModEntities;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MaggotRenderer extends MobRenderer<MaggotEntity, MaggotModel> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(LastPraiseOfMaggot.MODID, "textures/entity/brother_maggot.png");
    private static final ResourceLocation SISTER_MAGGOT_TEXTURE =
            new ResourceLocation(LastPraiseOfMaggot.MODID, "textures/entity/sister_maggot.png");

    private static final ResourceLocation RAINBOW_MAGGOT_TEXTURE =
            new ResourceLocation(LastPraiseOfMaggot.MODID, "textures/entity/rainbow_maggot.png");
    private static final ResourceLocation PURE_GOLD_MAGGOT_TEXTURE =
            new ResourceLocation(LastPraiseOfMaggot.MODID, "textures/entity/pure_gold_maggot.png");

    private static final ResourceLocation YELLOW_PURPLE_MAGGOT_TEXTURE =
            new ResourceLocation(LastPraiseOfMaggot.MODID, "textures/entity/yellow_purple_maggot.png");

    public MaggotRenderer(EntityRendererProvider.Context context) {
        super(context, new MaggotModel(context.bakeLayer(MaggotModel.LAYER_LOCATION)), 0.55F);
    }

    @Override
    protected void scale(MaggotEntity entity, PoseStack poseStack, float partialTickTime) {
        boolean sister = entity.getType() == ModEntities.SISTER_MAGGOT.get()
                || entity.getType() == ModEntities.BABY_SISTER_MAGGOT.get();
        float scale = (sister ? 0.92F : 1.05F) * entity.getScale();
        this.shadowRadius = 0.55F * entity.getScale();
        poseStack.scale(scale, scale, scale);
    }

    @Override
    public ResourceLocation getTextureLocation(MaggotEntity entity) {
        if (entity.getType() == ModEntities.SISTER_MAGGOT.get()
                || entity.getType() == ModEntities.BABY_SISTER_MAGGOT.get()) return SISTER_MAGGOT_TEXTURE;
        if (entity.getType() == ModEntities.RAINBOW_MAGGOT.get()
                || entity.getType() == ModEntities.BABY_RAINBOW_MAGGOT.get()) return RAINBOW_MAGGOT_TEXTURE;
        if (entity.getType() == ModEntities.PURE_GOLD_MAGGOT.get()
                || entity.getType() == ModEntities.BABY_PURE_GOLD_MAGGOT.get()) return PURE_GOLD_MAGGOT_TEXTURE;
        if (entity.getType() == ModEntities.YELLOW_PURPLE_MAGGOT.get()
                || entity.getType() == ModEntities.BABY_YELLOW_PURPLE_MAGGOT.get()) return YELLOW_PURPLE_MAGGOT_TEXTURE;
        return TEXTURE;
    }
}

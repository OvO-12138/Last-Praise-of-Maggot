package com.ovo.lastpraiseofmaggot.client.renderer;

import com.ovo.lastpraiseofmaggot.entity.YellowPurpleBabyAxolotlEntity;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import net.minecraft.client.model.AxolotlModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class YellowPurpleBabyAxolotlRenderer
        extends MobRenderer<YellowPurpleBabyAxolotlEntity, AxolotlModel<YellowPurpleBabyAxolotlEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
            LastPraiseOfMaggot.MODID,
            "textures/entity/yellow_purple_little_axolotl_baby.png"
    );

    public YellowPurpleBabyAxolotlRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new AxolotlModel<>(context.bakeLayer(ModelLayers.AXOLOTL)),
                0.2F
        );
    }

    @Override
    public ResourceLocation getTextureLocation(YellowPurpleBabyAxolotlEntity axolotl) {
        return TEXTURE;
    }
}

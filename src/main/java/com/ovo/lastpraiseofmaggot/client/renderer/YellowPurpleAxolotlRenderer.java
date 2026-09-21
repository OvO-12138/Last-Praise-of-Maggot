package com.ovo.lastpraiseofmaggot.client.renderer;

import com.ovo.lastpraiseofmaggot.entity.YellowPurpleAxolotlEntity;
import com.ovo.lastpraiseofmaggot.LastPraiseOfMaggot;
import net.minecraft.client.model.AxolotlModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class YellowPurpleAxolotlRenderer
        extends MobRenderer<YellowPurpleAxolotlEntity, AxolotlModel<YellowPurpleAxolotlEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
            LastPraiseOfMaggot.MODID,
            "textures/entity/yellow_purple_little_axolotl.png"
    );

    public YellowPurpleAxolotlRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new AxolotlModel<>(context.bakeLayer(ModelLayers.AXOLOTL)),
                0.35F
        );
    }

    @Override
    public ResourceLocation getTextureLocation(YellowPurpleAxolotlEntity axolotl) {
        return TEXTURE;
    }
}

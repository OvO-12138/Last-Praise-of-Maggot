package com.ovo.lastpraiseofmaggot.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockEntity.class)
public abstract class LegacyBlockEntityMixin {
    // Block entity names in chunk NBT bypass Forge's saved numeric registry remapping.
    @Inject(method = "loadStatic", at = @At("HEAD"))
    private static void lastpraiseofmaggot$remapLegacyBed(
            BlockPos pos, BlockState state, CompoundTag tag,
            CallbackInfoReturnable<BlockEntity> callback) {
        if (tag.getString("id").equals("lastsongofelysian:yellow_purple_little_bed")) {
            tag.putString("id", "lastpraiseofmaggot:yellow_purple_little_bed");
        }
    }
}

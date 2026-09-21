package com.ovo.lastpraiseofmaggot.mixin;

import com.ovo.lastpraiseofmaggot.registry.ModItems;
import net.minecraft.world.entity.animal.Chicken;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chicken.class)
public abstract class ChickenEggMixin {
    @Inject(method = "aiStep", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/entity/animal/Chicken;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/entity/item/ItemEntity;",
            shift = At.Shift.AFTER))
    private void lastpraiseofmaggot$dropChickenPoop(CallbackInfo callback) {
        Chicken chicken = (Chicken) (Object) this;
        if (!chicken.level().isClientSide && chicken.getRandom().nextBoolean())
            chicken.spawnAtLocation(ModItems.CHICKEN_POOP.get());
    }
}

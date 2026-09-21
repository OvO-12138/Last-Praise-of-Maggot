package com.ovo.lastpraiseofmaggot.item;


import com.ovo.lastpraiseofmaggot.registry.ModArmorMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class NamelessTownChestplateItem extends ArmorItem {

    public NamelessTownChestplateItem(Properties properties) {
        super(ModArmorMaterials.NAMELESS_TOWN, Type.CHESTPLATE, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.lastpraiseofmaggot.nameless_town_chestplate")
                .withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, level, tooltip, flag);
    }
}

package com.ovo.lastpraiseofmaggot.client;

import com.ovo.lastpraiseofmaggot.item.MaggotBookContent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class MaggotBookHooks {
    public static void openCareBook() {
        Minecraft.getInstance().setScreen(new BookViewScreen(new BookViewScreen.BookAccess() {
            @Override public int getPageCount() { return MaggotBookContent.PAGE_COUNT; }
            @Override public FormattedText getPageRaw(int page) {
                return Component.translatable(MaggotBookContent.pageKey(page));
            }
        }));
    }
    private MaggotBookHooks() {}
}

package com.ovo.lastpraiseofmaggot.item;

/** Fixed chapter order; pages are resolved in the reader's current language. */
public final class MaggotBookContent {
    public static final int PAGE_COUNT = 15;
    public static String pageKey(int page) { return "book.lastpraiseofmaggot.maggot_care.page_" + (page + 1); }
    private MaggotBookContent() {}
}

package com.floofappreciationclub.vulpinian_skies_core.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab FOX_TAB = new CreativeModeTab("foxtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.SMILE.get());
        }
    };
}

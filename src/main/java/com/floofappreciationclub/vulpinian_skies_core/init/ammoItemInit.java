package com.floofappreciationclub.vulpinian_skies_core.init;

import com.floofappreciationclub.vulpinian_skies_core.VulpinianSkiesCore;
import com.mrcrayfish.guns.item.GrenadeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Deprecated
public class ammoItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VulpinianSkiesCore.MOD_ID);

    public static final RegistryObject<Item> ETHEREAL_GRENADE = ITEMS.register("ethereal_grenade", () -> new GrenadeItem(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB), 20 * 4));

    public static final RegistryObject<Item> SMILETWO = ITEMS.register("smile_two",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB)));

}

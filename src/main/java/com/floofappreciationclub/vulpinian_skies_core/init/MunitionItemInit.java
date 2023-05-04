package com.floofappreciationclub.vulpinian_skies_core.init;

import com.floofappreciationclub.vulpinian_skies_core.Reference;
import com.floofappreciationclub.vulpinian_skies_core.items.EtherealGrenadeItem;
import com.mrcrayfish.guns.item.AmmoItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MunitionItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
    public static final Item.Properties genericProperties = new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.FOX_TAB);

    public static final RegistryObject<Item> ETHEREALGRENADE = registerEtherealGrenade("ethereal_grenade");

    private static RegistryObject<Item> registerEtherealGrenade(String name) {
        return ITEMS.register(name, () -> new EtherealGrenadeItem(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB), 20 * 3));
    }
}


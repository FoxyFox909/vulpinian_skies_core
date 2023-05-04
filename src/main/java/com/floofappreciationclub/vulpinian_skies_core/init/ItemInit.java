package com.floofappreciationclub.vulpinian_skies_core.init;

import com.floofappreciationclub.vulpinian_skies_core.VulpinianSkiesCore;
//import net.minecraft.world.item.CreativeModeTab;
import com.floofappreciationclub.vulpinian_skies_core.items.EtherealGrenadeItem;
import com.floofappreciationclub.vulpinian_skies_core.items.FuelItem;
import com.floofappreciationclub.vulpinian_skies_core.items.TeleportStaff;
import com.mrcrayfish.guns.item.GrenadeItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VulpinianSkiesCore.MOD_ID);

    public static final RegistryObject<Item> SMILE = ITEMS.register("smile",
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB)));

    public static final RegistryObject<Item> TOFU = ITEMS.register("tofu",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.FOX_TAB)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(2).build())
            ));

    public static final RegistryObject<Item> FUEL = ITEMS.register("fuel",
            () -> new FuelItem(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB), 1000));


    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("teleport_staff",
            () -> new TeleportStaff(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB)));

    //public static final RegistryObject<Item> ETHEREAL_GRENADE = ITEMS.register("ethereal_grenade", () -> new EtherealGrenadeItem(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB), 20 * 4));
    //public static final RegistryObject<Item> ETHEREAL_GRENADE = REGISTER.register("ethereal_grenade", () -> new EtherealGrenadeItem(new Item.Properties().tab(ModCreativeModeTab.FOX_TAB), 20 * 4));

  /*  public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab(int index, String label) {
            super(index, label);
            new Item.Properties().tab(ModCreativeTab.instance);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.SMILE.get());
        }

        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "helloworldfromfox");

    };
    */











}

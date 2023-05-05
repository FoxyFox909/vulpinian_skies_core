package com.floofappreciationclub.vulpinian_skies_core.init;

import java.util.Objects;
import java.util.function.BiFunction;

import com.floofappreciationclub.vulpinian_skies_core.Reference;

//import com.floofappreciationclub.vulpinian_skies_core.entity.ThrowableEtherealGrenadeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.floofappreciationclub.vulpinian_skies_core.entity.EtherealGrenadeEntity;
import com.floofappreciationclub.vulpinian_skies_core.entity.ThrowableEtherealGrenadeEntity;

public class MunitionEntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Reference.MOD_ID);
    public static final RegistryObject<EntityType<EtherealGrenadeEntity>> ETHEREAL_GRENADE = registerBasic("ethereal_grenade", EtherealGrenadeEntity::new);
    public static final RegistryObject<EntityType<ThrowableEtherealGrenadeEntity>> THROWABLE_ETHEREAL_GRENADE = registerBasic("throwable_ethereal_grenade", ThrowableEtherealGrenadeEntity::new);

    private static <T extends Entity> RegistryObject<EntityType<T>> registerBasic(String id, BiFunction<EntityType<T>, Level, T> function)
    {
        return ENTITIES.register(id, () -> {

                Objects.requireNonNull(function);
                return EntityType.Builder.of(function::apply, MobCategory.MISC)
                .sized(0.25F, 0.25F)
                .setTrackingRange(100)
                .setUpdateInterval(1)
                .noSummon()
                .fireImmune()
                .setShouldReceiveVelocityUpdates(true).build(id);
        });
    }

}

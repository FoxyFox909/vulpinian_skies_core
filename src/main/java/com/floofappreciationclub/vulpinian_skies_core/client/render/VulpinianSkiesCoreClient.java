package com.floofappreciationclub.vulpinian_skies_core.client.render;


import com.floofappreciationclub.vulpinian_skies_core.Reference;
import com.floofappreciationclub.vulpinian_skies_core.client.render.entity.EtherealGrenadeRenderer;
import com.mrcrayfish.guns.client.render.entity.GrenadeRenderer;
import com.mrcrayfish.guns.client.render.entity.ProjectileRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import com.floofappreciationclub.vulpinian_skies_core.init.MunitionEntityInit;

@EventBusSubscriber(
        modid = Reference.MOD_ID,
        value = {Dist.CLIENT},
        bus = Bus.MOD
)

public class VulpinianSkiesCoreClient {
    public VulpinianSkiesCoreClient() {
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType)MunitionEntityInit.ETHEREAL_GRENADE.get(), EtherealGrenadeRenderer::new);
    }

}

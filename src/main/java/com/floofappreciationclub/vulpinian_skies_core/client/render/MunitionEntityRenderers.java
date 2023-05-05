package com.floofappreciationclub.vulpinian_skies_core.client.render;

import com.floofappreciationclub.vulpinian_skies_core.Reference;
import com.floofappreciationclub.vulpinian_skies_core.client.render.entity.EtherealGrenadeRenderer;
import com.floofappreciationclub.vulpinian_skies_core.client.render.entity.ThrowableEtherealGrenadeRenderer;
import com.floofappreciationclub.vulpinian_skies_core.init.MunitionEntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MunitionEntityRenderers {
        @SubscribeEvent
        public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerEntityRenderer(MunitionEntityInit.ETHEREAL_GRENADE.get(), EtherealGrenadeRenderer::new);
            event.registerEntityRenderer(MunitionEntityInit.THROWABLE_ETHEREAL_GRENADE.get(), ThrowableEtherealGrenadeRenderer::new);
        }
}

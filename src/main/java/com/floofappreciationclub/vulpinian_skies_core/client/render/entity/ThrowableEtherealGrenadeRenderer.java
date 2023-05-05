package com.floofappreciationclub.vulpinian_skies_core.client.render.entity;

import com.floofappreciationclub.vulpinian_skies_core.entity.ThrowableEtherealGrenadeEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class ThrowableEtherealGrenadeRenderer extends EntityRenderer<ThrowableEtherealGrenadeEntity>
{
    public ThrowableEtherealGrenadeRenderer(EntityRendererProvider.Context context)
    {
        super(context);
    }

    @Nullable
    @Override
    public ResourceLocation getTextureLocation(ThrowableEtherealGrenadeEntity entity)
    {
        return null;
    }

    @Override
    public void render(ThrowableEtherealGrenadeEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource renderTypeBuffer, int light)
    {
        poseStack.pushPose();

        /* Makes the grenade face in the direction of travel */
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180F));
        poseStack.mulPose(Vector3f.YP.rotationDegrees(entityYaw));

        /* Offsets to the center of the grenade before applying rotation */
        float rotation = entity.prevRotation + (entity.rotation - entity.prevRotation) * partialTicks;
        poseStack.translate(0, 0.15, 0);
        poseStack.mulPose(Vector3f.XP.rotationDegrees(-rotation));
        poseStack.translate(0, -0.15, 0);

        /* */
        poseStack.translate(0.0, 0.5, 0.0);

        Minecraft.getInstance().getItemRenderer().renderStatic(entity.getItem(), ItemTransforms.TransformType.NONE, light, OverlayTexture.NO_OVERLAY, poseStack, renderTypeBuffer, 0);

        poseStack.popPose();
    }

}

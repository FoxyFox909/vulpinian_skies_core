package com.floofappreciationclub.vulpinian_skies_core.entity;

import com.mrcrayfish.guns.Config;
import com.floofappreciationclub.vulpinian_skies_core.init.MunitionEntityInit;
import com.floofappreciationclub.vulpinian_skies_core.init.MunitionItemInit;
import com.mrcrayfish.guns.entity.ThrowableItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.Level;


public class ThrowableEtherealGrenadeEntity extends ThrowableItemEntity
{

    public float rotation;
    public float prevRotation;

    public ThrowableEtherealGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level worldIn)
    {
        super(entityType, worldIn);
    }

    public ThrowableEtherealGrenadeEntity(EntityType<? extends ThrowableItemEntity> entityType, Level world, LivingEntity entity)
    {
        super(entityType, world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(MunitionItemInit.ETHEREAL_GRENADE.get()));
        this.setMaxLife(20 * 3);
    }

    public ThrowableEtherealGrenadeEntity(Level world, LivingEntity entity, int timeLeft)
    {
        super(MunitionEntityInit.THROWABLE_ETHEREAL_GRENADE.get(), world, entity);
        this.setShouldBounce(true);
        this.setGravityVelocity(0.05F);
        this.setItem(new ItemStack(MunitionItemInit.ETHEREAL_GRENADE.get()));
        this.setMaxLife(timeLeft);
    }

    @Override
    protected void defineSynchedData()
    {
    }

    @Override
    public void tick()
    {
        super.tick();
        this.prevRotation = this.rotation;
        double speed = this.getDeltaMovement().length();
        if (speed > 0.1)
        {
            this.rotation += speed * 50;
        }
        if (this.level.isClientSide)
        {
            this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, true, this.getX() - (this.getDeltaMovement().x() / 2), this.getY() - (this.getDeltaMovement().y() / 2), this.getZ() - (this.getDeltaMovement().z() / 2), 0 + random.nextDouble(0.075), 0 + random.nextDouble(0.075), 0 + random.nextDouble(0.075));
        }
    }

    @Override
    public void onDeath()
    {
        if (!this.level.isClientSide) {
            for (int p = 0; p < 50; p++) {
                ((ServerLevel) this.level).sendParticles(ParticleTypes.SOUL_FIRE_FLAME, this.getX() - 1.0 + this.random.nextDouble() * 2.0, this.getY(), this.getZ() - 1.0 + this.random.nextDouble() * 2.0, 4, 2.0, 1.0, 2.0, 0.5);
            }
        }
        EtherealGrenadeEntity.createExplosion(this, Config.COMMON.grenades.explosionRadius.get().floatValue(), false);
    }
}

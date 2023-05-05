package com.floofappreciationclub.vulpinian_skies_core.entity;

import com.mrcrayfish.guns.common.Gun;
import com.mrcrayfish.guns.entity.ProjectileEntity;
import com.mrcrayfish.guns.item.GunItem;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;


public class EtherealGrenadeEntity extends ProjectileEntity {

    boolean exploded = false;

    public EtherealGrenadeEntity(EntityType<? extends ProjectileEntity> entityType, Level world) {
        super(entityType, world);
    }

    public EtherealGrenadeEntity(EntityType<? extends ProjectileEntity> entityType, Level world, LivingEntity shooter, ItemStack weapon, GunItem item, Gun modifiedGun) {
        super(entityType, world, shooter, weapon, item, modifiedGun);
    }

    protected void onProjectileTick() {

        if (this.level.isClientSide) {
            for (int i = 0; i < 5; i++) {
                this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, true, this.getX() - (this.getDeltaMovement().x() / i), this.getY() - (this.getDeltaMovement().y() / i), this.getZ() - (this.getDeltaMovement().z() / i), 0 + random.nextDouble(0.075), 0 + random.nextDouble(0.075), 0 + random.nextDouble(0.075));
            }
            if (exploded) {
                for (int i = 0; i < 200; i++) {
                    System.out.println("Attempting to summon particle");
                    this.level.addParticle(ParticleTypes.LAVA, true, this.getX() - (this.getDeltaMovement().x() / i), this.getY() - (this.getDeltaMovement().y() / i), this.getZ() - (this.getDeltaMovement().z() / i), 0.1D, 0.1D, 0.1D);
                }
            }
        }
    }



    /*private void particlesandsounds(BlockPos pos) {
        ((WorldServer) world).spawnParticle(EnumParticleTypes.FLAME, // particleType,
                false, // long distance
                pos.getX(), pos.up().getY(), pos.getZ(), // xCoord, yCoord, zCoord,
                10, // numberOfParticles,
                1, 0, 1, // xOffset, yOffset, zOffset,
                0d // particleSpeed,
        );
    }*/


    /*protected void explosionParticles() {

        if (this.level.isClientSide) {
                for (int p = 0; p < 200; p++) {
                    System.out.println("Attempting to summon particle");
                    //this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, true, this.getX(), this.getY() + 1.5D, this.getZ(), 0D, 0.1D, 0D);
                    this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, true, this.getX() - (this.getDeltaMovement().x() / p), this.getY() - (this.getDeltaMovement().y() / p), this.getZ() - (this.getDeltaMovement().z() / p), 0 + random.nextDouble(0.075), 0 + random.nextDouble(0.075), 0 + random.nextDouble(0.075));
                }
        } else {System.out.println("Unable to summon particle"); System.out.println(random.nextDouble(0.075));}
    }*/

    @Override
    protected void onHitEntity(Entity entity, Vec3 hitVec, Vec3 startVec, Vec3 endVec, boolean headshot)
    {
        createExplosion(this, this.getDamage() / 2F, true);
    }

    @Override
    protected void onHitBlock(BlockState state, BlockPos pos, Direction face, double x, double y, double z)
    {

        //explosionParticles();
        exploded = true;
        createExplosion(this, this.getDamage() / 2F, false);

        for (int p = 0; p < 100; p++) {
            System.out.println("summoning particle");
            ((ServerLevel)this.level).sendParticles(ParticleTypes.LAVA, this.getX() - 1.0 + this.random.nextDouble() * 2.0, this.getY(), this.getZ() - 1.0 + this.random.nextDouble() * 2.0, 4, 0.0, 0.0, 0.0, 0.0);
        }
        System.out.println("post boom: " + this.level.isClientSide);
        System.out.println("XYZ:" + this.position().x + " " + this.position().y + " " + this.position().z);


        //net.minecraft.world.WorldServer


    }

    @Override
    public void onExpired()
    {
        createExplosion(this, this.getDamage() / 2F, true);
    }


}

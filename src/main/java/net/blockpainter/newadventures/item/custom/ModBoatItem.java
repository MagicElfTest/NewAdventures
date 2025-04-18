/*package net.blockpainter.newadventures.item.custom;

import net.blockpainter.newadventures.entity.custom.ModBoatEntity;
import net.blockpainter.newadventures.entity.custom.ModChestBoatEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.item.Item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class ModBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final ModBoatEntity.Type type;
    private final boolean hasChest;

    public ModBoatItem(boolean pHasChest, ModBoatEntity.Type pType, Item.Properties pProperties) {
        super(pProperties);
        this.hasChest = pHasChest;
        this.type = pType;
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        HitResult hit = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);

        if (hit.getType() == HitResult.Type.MISS) {
            return InteractionResult.PASS;
        }

        // ( ... ray‐trace entity avoidance code ... )

        if (hit.getType() == HitResult.Type.BLOCK) {
            AbstractBoat boat = this.getBoat(level, hit);

            // set the variant on the correct subclass
            if (boat instanceof ModBoatEntity mboat) {
                mboat.setVariant(this.type);
            } else if (boat instanceof ModChestBoatEntity cboat) {
                cboat.setVariant(this.type);
            } else {
                return InteractionResult.FAIL;
            }

            boat.setYRot(player.getYRot());
            if (!level.noCollision(boat, boat.getBoundingBox())) {
                return InteractionResult.FAIL;
            }

            if (!level.isClientSide) {
                level.addFreshEntity(boat);
                level.gameEvent(player, GameEvent.ENTITY_PLACE, hit.getLocation());
                if (!player.getAbilities().instabuild) stack.shrink(1);
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            return level.isClientSide() ? InteractionResult.SUCCESS : InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }

    // Correct method for boat creation: Either a regular Boat or a ChestBoat
    private AbstractBoat getBoat(Level level, HitResult hit) {
        double x = hit.getLocation().x;
        double y = hit.getLocation().y;
        double z = hit.getLocation().z;

        if (this.hasChest) {
            return new ModChestBoatEntity(level, x, y, z);
        } else {
            return new ModBoatEntity(level, x, y, z);
        }
    }
}*/

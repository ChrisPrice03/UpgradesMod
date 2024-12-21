package net.squawknog.upgradesmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.squawknog.upgradesmod.handler.UpgradeHandler;
import net.squawknog.upgradesmod.item.ModItems;

public class SummoningUpgraderBlock extends Block {
    public SummoningUpgraderBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player
            pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        // Check if the item used is the Upgrade Token
        if (pStack.getItem() == ModItems.UPGRADE_TOKEN.get()) {
            if (!pLevel.isClientSide) { // Server-side logic
                //What happens when the lock is activated

                // Remove one Upgrade Token from the player's stack
                pStack.shrink(1);

                // Remove the block from the world
                pLevel.removeBlock(pPos, false);

                pLevel.playSound(null, pPos, SoundEvents.PLAYER_LEVELUP,
                        SoundSource.BLOCKS, 1.0F, 1.0F);

                UpgradeHandler.setUpgradeLevel(pPlayer, "upgradesmod.summoningUpgrade",
                        UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.summoningUpgrade") + 1);

                // Return a success result
                return ItemInteractionResult.SUCCESS;
            }
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }
}

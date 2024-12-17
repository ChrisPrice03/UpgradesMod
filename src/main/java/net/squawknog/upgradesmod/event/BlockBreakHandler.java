package net.squawknog.upgradesmod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.squawknog.upgradesmod.UpgradesMod;
import net.squawknog.upgradesmod.handler.UpgradeHandler;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = UpgradesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlockBreakHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        Level level = player.level();

        // Check if on server-side
        if (!level.isClientSide()) {
            // Retrieve the player's luck level
            int luckLevel = UpgradeHandler.getUpgradeLevel(player, "upgradesmod.luckUpgrade");

            // Calculate the chance of triggering the random block drop
            double chance = 0.0 + (luckLevel * 0.01); // Base chance: 10%, increases by 2% per luck level
            if (Math.random() < chance) {
                // Get a random item
                ItemStack randomDrop = getRandomDrop(luckLevel);

                // Drop the block at the broken block's position
                BlockPos pos = event.getPos();
                ItemEntity droppedEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        randomDrop);
                level.addFreshEntity(droppedEntity);
            }
        }
    }

    private static ItemStack getRandomDrop(int luckLevel) {
        // Get a list of all registered blocks
        List<Item> allItems = ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> item != Items.AIR) // Remove air
                .toList();

        // Pick a random block
        Random random = new Random();
        Item randomItem = allItems.get(random.nextInt(allItems.size()));

        return new ItemStack(randomItem);
    }
}


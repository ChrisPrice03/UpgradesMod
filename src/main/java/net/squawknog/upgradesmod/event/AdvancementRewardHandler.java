package net.squawknog.upgradesmod.event;

import net.minecraft.advancements.Advancement;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.squawknog.upgradesmod.item.ModItems;

@Mod.EventBusSubscriber
public class AdvancementRewardHandler {

    @SubscribeEvent
    public static void onAdvancementComplete(net.minecraftforge.event.entity.player.AdvancementEvent event) {
        // Check if the player is on the server
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        Advancement advancement = event.getAdvancement().value();
        if (advancement.toString().contains("recipes/")) return;

        Level level = player.level();
        if(level.isClientSide()) return;

        if (hasReceivedUpgradeToken(player, advancement)) return;
        markUpgradeTokenGiven(player, advancement);

        System.out.println(advancement.toString());

        // Grant the player an Upgrade Token
        ItemStack upgradeToken = new ItemStack(ModItems.UPGRADE_TOKEN.get());
        if (!player.addItem(upgradeToken)) {
            // If inventory is full, drop the token in the world
            player.drop(upgradeToken, false);
        }

        // Notify the player
        player.displayClientMessage(Component.literal("You've received an Upgrade Token!"), true);
    }

    // Helper method to track if the player has already received the token for this advancement
    private static boolean hasReceivedUpgradeToken(ServerPlayer player, Advancement advancement) {
        // Check player data or use a custom flag (e.g., NBT or player data) to track
        return player.getPersistentData().getBoolean("hasReceivedUpgradeToken_" + advancement.toString());
    }

    // Helper method to mark that the player has received the upgrade token for this advancement
    private static void markUpgradeTokenGiven(ServerPlayer player, Advancement advancement) {
        // Store this information in player data (e.g., NBT) to prevent duplicate rewards
        player.getPersistentData().putBoolean("hasReceivedUpgradeToken_" + advancement.toString(), true);
    }
}
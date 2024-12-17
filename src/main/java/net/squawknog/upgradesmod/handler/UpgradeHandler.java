package net.squawknog.upgradesmod.handler;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class UpgradeHandler {

    // Store a specific upgrade level for a player
    public static void setUpgradeLevel(Player player, String upgradeKey, int level) {
        CompoundTag playerData = player.getPersistentData();  // Get player's persistent data

        // Store the upgrade level in the player's persistent data container
        playerData.putInt(upgradeKey, level);
    }

    // Get a specific upgrade level for a player
    public static int getUpgradeLevel(Player player, String upgradeKey) {
        CompoundTag playerData = player.getPersistentData();  // Get player's persistent data

        // Return the upgrade level, defaulting to 0 if not found
        return playerData.getInt(upgradeKey);
    }
}

package net.squawknog.upgradesmod.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.squawknog.upgradesmod.handler.UpgradeHandler;
import net.squawknog.upgradesmod.screen.UpgradeInterfaceScreen;

public class UpgradeInterfaceItem extends Item {
    public UpgradeInterfaceItem(Properties pProperties) {
        super(pProperties);
    }
    public static String upgradesText = "";
    public static String abilitiesText = "";
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide()) {
            upgradesText = buildUpgradesText(pPlayer);
            abilitiesText = buildAbilitiesText(pPlayer);
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }

        Minecraft.getInstance().setScreen(new UpgradeInterfaceScreen(Component.translatable("screen.upgradesmod.upgrade_interface")));


        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    //builds player upgrades string
    private String buildUpgradesText(Player pPlayer) {
        int saturation = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.saturationUpgrade");
        int speed = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.speedUpgrade");
        int health = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.healthUpgrade");
        int summoning = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.summoningUpgrade");
        int teleportation = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.teleportationUpgrade");
        int strength = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.strengthUpgrade");
        int haste = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.hasteUpgrade");
        int fortune = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.fortuneUpgrade");
        int luck = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.luckUpgrade");
        int flame = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.flameUpgrade");

        // Build the text to display the "luck" skill and its level
        return "Upgrades:\n" +
                "Saturation: " + saturation + "\n" +
                "Speed: " + speed + "\n" +
                "Health: " + health + "\n" +
                "Summoning: " + summoning + "\n" +
                "Teleportation: " + teleportation + "\n\n" +
                "Strength: " + strength + "\n" +
                "Haste: " + haste + "\n" +
                "Fortune: " + fortune + "\n\n" +
                "Luck: " + luck + "\n\n" +
                "Flame: " + flame;

    }

    //builds player abilities strings
    private String buildAbilitiesText(Player pPlayer) {
        int saturation = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.saturationUpgrade");
        int speed = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.speedUpgrade");
        int health = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.healthUpgrade");
        int summoning = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.summoningUpgrade");
        int teleportation = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.teleportationUpgrade");
        int strength = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.strengthUpgrade");
        int haste = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.hasteUpgrade");
        int fortune = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.fortuneUpgrade");
        int luck = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.luckUpgrade");
        int flame = UpgradeHandler.getUpgradeLevel(pPlayer, "upgradesmod.flameUpgrade");

        // Build the text to display the skills and levels
        return "Abilities:\n" +
                "Bonus " + saturation + " Saturation\n" +
                "Bonus " + speed + "% Movespeed\n" +
                "Bonus " + health + " Hearts\n" +
                "Can Summon " + summoning + " Mobs\n" +
                "Can teleport up to " + teleportation + "\n" +
                "blocks\n" +
                "Deals " + strength + "% more damage\n" +
                "Mines " + haste + "% faster\n" +
                "Has " + fortune + "% chance to\n" +
                "double a mined block\n" +
                luck + "% chance to drop a\n" +
                "random block when mining\n" +
                "Hits apply fire for " + flame + "\n" +
                "seconds";

    }
}

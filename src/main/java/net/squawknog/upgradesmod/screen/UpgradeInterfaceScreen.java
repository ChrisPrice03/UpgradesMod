package net.squawknog.upgradesmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.squawknog.upgradesmod.item.custom.UpgradeInterfaceItem;

public class UpgradeInterfaceScreen extends Screen {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("upgradesmod",
            "textures/gui/upgrade_interface_gui.png");

    private final int imageWidth = 256;
    private final int imageHeight = 256;

    public UpgradeInterfaceScreen(Component pTitle) {
        super(pTitle);
    }

    @Override
    public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
//        RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 0.0F);
//        super.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);

        // Center the GUI on screen
        int x = (this.width - imageWidth) / 2;
        int y = (this.height - imageHeight) / 2;

        // Render the GUI texture
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        //Upgrades text
        int upgradesTextX = x + 20;  // Horizontal position of the text
        int upgradesTextY = y + 20;  // Vertical position of the text
        int defaultColor = 0xffffff;

        String upgradesText = UpgradeInterfaceItem.upgradesText;
        String[] upgradesLines = upgradesText.split("\n");

        int lineSpacing = 15;

        for (int i = 0; i < upgradesLines.length; i++) {
            // Render each line separately in your custom GUI (example in Minecraft GUI rendering code)
            pGuiGraphics.drawString(this.font, upgradesLines[i], upgradesTextX, upgradesTextY + (i * lineSpacing), defaultColor);
        }

        //Bonus Abilities text
        int abilityTextX = x + 110;  // Horizontal position of the text
        int abilityTextY = y + 20;  // Vertical position of the text

        String abilitiesText = UpgradeInterfaceItem.abilitiesText;
        String[] abilitiesLines = abilitiesText.split("\n");

        for (int i = 0; i < abilitiesLines.length; i++) {
            // Render each line separately in your custom GUI (example in Minecraft GUI rendering code)
            pGuiGraphics.drawString(this.font, abilitiesLines[i], abilityTextX, abilityTextY + (i * lineSpacing), defaultColor);
        }

        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

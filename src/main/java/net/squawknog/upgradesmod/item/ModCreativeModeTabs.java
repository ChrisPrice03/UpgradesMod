package net.squawknog.upgradesmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.squawknog.upgradesmod.UpgradesMod;
import net.squawknog.upgradesmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UpgradesMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> UPGRADES_ITEMS = CREATIVE_MODE_TABS.register("upgrades_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.UPGRADE_TOKEN.get()))
                    .title(Component.translatable("creativetab.upgradesmod.upgrade_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //add items here
                        output.accept(ModItems.UPGRADE_TOKEN.get());
                        output.accept(ModItems.UPGRADE_INTERFACE.get());
                        output.accept(ModBlocks.GENERIC_UPGRADER.get());
                        output.accept(ModBlocks.LUCK_UPGRADER.get());
                        output.accept(ModBlocks.SATURATION_UPGRADER.get());
                        output.accept(ModBlocks.SPEED_UPGRADER.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

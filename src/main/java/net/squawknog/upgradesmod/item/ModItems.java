package net.squawknog.upgradesmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.squawknog.upgradesmod.UpgradesMod;
import net.squawknog.upgradesmod.item.custom.UpgradeInterfaceItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UpgradesMod.MOD_ID);

    //defining new items
    public static final RegistryObject<Item> UPGRADE_TOKEN = ITEMS.register("upgrade_token",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> UPGRADE_INTERFACE = ITEMS.register("upgrade_interface",
            () -> new UpgradeInterfaceItem(new Item.Properties().stacksTo(1)));

    //method to register items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

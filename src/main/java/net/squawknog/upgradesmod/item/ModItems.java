package net.squawknog.upgradesmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.squawknog.upgradesmod.UpgradesMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UpgradesMod.MOD_ID);

    //defining new items
    public static final RegistryObject<Item> UPGRADE_TOKEN = ITEMS.register("upgrade_token",
            () -> new Item(new Item.Properties()));

    //method to register items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

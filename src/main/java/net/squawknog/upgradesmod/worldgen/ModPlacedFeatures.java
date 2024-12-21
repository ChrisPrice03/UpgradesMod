package net.squawknog.upgradesmod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.squawknog.upgradesmod.UpgradesMod;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> LUCK_UPGRADER_PLACED_KEY = registerKey("luck_upgrader_placed");
    public static final ResourceKey<PlacedFeature> SATURATION_UPGRADER_PLACED_KEY = registerKey("saturation_upgrader_placed");
    public static final ResourceKey<PlacedFeature> SPEED_UPGRADER_PLACED_KEY = registerKey("speed_upgrader_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LUCK_UPGRADER_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.LUCK_UPGRADER_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(256), // Controls the rarity of spawning
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, // Spawns at the world surface
                        BiomeFilter.biome() // Make it spawn in any biome (adjust as needed)
                ));

        register(context, SATURATION_UPGRADER_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.SATURATION_UPGRADER_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(128), // Controls the rarity of spawning
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, // Spawns at the world surface
                        BiomeFilter.biome() // Make it spawn in any biome (adjust as needed)
                ));

        register(context, SPEED_UPGRADER_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.SPEED_UPGRADER_KEY),
                List.of(
                        RarityFilter.onAverageOnceEvery(128), // Controls the rarity of spawning
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, // Spawns at the world surface
                        BiomeFilter.biome() // Make it spawn in any biome (adjust as needed)
                ));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(UpgradesMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

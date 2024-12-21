package net.squawknog.upgradesmod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.squawknog.upgradesmod.UpgradesMod;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_LUCK_UPGRADER = registerKey("add_luck_upgrader");
    public static final ResourceKey<BiomeModifier> ADD_SATURATION_UPGRADER = registerKey("add_saturation_upgrader");
    public static final ResourceKey<BiomeModifier> ADD_SPEED_UPGRADER = registerKey("add_speed_upgrader");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_LUCK_UPGRADER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.PLAINS),
                        biomes.getOrThrow(Biomes.BADLANDS),
                        biomes.getOrThrow(Biomes.BAMBOO_JUNGLE),
                        biomes.getOrThrow(Biomes.BEACH),
                        biomes.getOrThrow(Biomes.BASALT_DELTAS),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.CHERRY_GROVE),
                        biomes.getOrThrow(Biomes.DARK_FOREST),
                        biomes.getOrThrow(Biomes.DESERT),
                        biomes.getOrThrow(Biomes.ERODED_BADLANDS),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST),
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.FROZEN_OCEAN),
                        biomes.getOrThrow(Biomes.GROVE),
                        biomes.getOrThrow(Biomes.GROVE),
                        biomes.getOrThrow(Biomes.ICE_SPIKES),
                        biomes.getOrThrow(Biomes.JUNGLE),
                        biomes.getOrThrow(Biomes.LUSH_CAVES),
                        biomes.getOrThrow(Biomes.MEADOW),
                        biomes.getOrThrow(Biomes.CRIMSON_FOREST),
                        biomes.getOrThrow(Biomes.DEEP_COLD_OCEAN),
                        biomes.getOrThrow(Biomes.NETHER_WASTES),
                        biomes.getOrThrow(Biomes.PLAINS),
                        biomes.getOrThrow(Biomes.SAVANNA),
                        biomes.getOrThrow(Biomes.SNOWY_BEACH),
                        biomes.getOrThrow(Biomes.END_BARRENS),
                        biomes.getOrThrow(Biomes.SWAMP),
                        biomes.getOrThrow(Biomes.TAIGA),
                        biomes.getOrThrow(Biomes.END_HIGHLANDS),
                        biomes.getOrThrow(Biomes.END_MIDLANDS),
                        biomes.getOrThrow(Biomes.WARPED_FOREST),
                        biomes.getOrThrow(Biomes.FROZEN_PEAKS),
                        biomes.getOrThrow(Biomes.FROZEN_RIVER),
                        biomes.getOrThrow(Biomes.JAGGED_PEAKS),
                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP),
                        biomes.getOrThrow(Biomes.MUSHROOM_FIELDS),
                        biomes.getOrThrow(Biomes.NETHER_WASTES),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_SPRUCE_TAIGA),
                        biomes.getOrThrow(Biomes.SAVANNA_PLATEAU),
                        biomes.getOrThrow(Biomes.SMALL_END_ISLANDS),
                        biomes.getOrThrow(Biomes.SNOWY_PLAINS),
                        biomes.getOrThrow(Biomes.SNOWY_SLOPES),
                        biomes.getOrThrow(Biomes.SNOWY_TAIGA),
                        biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY),
                        biomes.getOrThrow(Biomes.SPARSE_JUNGLE),
                        biomes.getOrThrow(Biomes.STONY_PEAKS),
                        biomes.getOrThrow(Biomes.STONY_SHORE),
                        biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS),
                        biomes.getOrThrow(Biomes.THE_END),
                        biomes.getOrThrow(Biomes.WINDSWEPT_FOREST),
                        biomes.getOrThrow(Biomes.WINDSWEPT_HILLS),
                        biomes.getOrThrow(Biomes.WINDSWEPT_SAVANNA),
                        biomes.getOrThrow(Biomes.WINDSWEPT_GRAVELLY_HILLS),
                        biomes.getOrThrow(Biomes.WOODED_BADLANDS),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.LUCK_UPGRADER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SPEED_UPGRADER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.PLAINS),
                        biomes.getOrThrow(Biomes.BADLANDS),
                        biomes.getOrThrow(Biomes.BAMBOO_JUNGLE),
                        biomes.getOrThrow(Biomes.BEACH),
                        biomes.getOrThrow(Biomes.BASALT_DELTAS),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.CHERRY_GROVE),
                        biomes.getOrThrow(Biomes.DARK_FOREST),
                        biomes.getOrThrow(Biomes.DESERT),
                        biomes.getOrThrow(Biomes.ERODED_BADLANDS),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST),
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.FROZEN_OCEAN),
                        biomes.getOrThrow(Biomes.GROVE),
                        biomes.getOrThrow(Biomes.GROVE),
                        biomes.getOrThrow(Biomes.ICE_SPIKES),
                        biomes.getOrThrow(Biomes.JUNGLE),
                        biomes.getOrThrow(Biomes.LUSH_CAVES),
                        biomes.getOrThrow(Biomes.MEADOW),
                        biomes.getOrThrow(Biomes.CRIMSON_FOREST),
                        biomes.getOrThrow(Biomes.DEEP_COLD_OCEAN),
                        biomes.getOrThrow(Biomes.NETHER_WASTES),
                        biomes.getOrThrow(Biomes.PLAINS),
                        biomes.getOrThrow(Biomes.SAVANNA),
                        biomes.getOrThrow(Biomes.SNOWY_BEACH),
                        biomes.getOrThrow(Biomes.END_BARRENS),
                        biomes.getOrThrow(Biomes.SWAMP),
                        biomes.getOrThrow(Biomes.TAIGA),
                        biomes.getOrThrow(Biomes.END_HIGHLANDS),
                        biomes.getOrThrow(Biomes.END_MIDLANDS),
                        biomes.getOrThrow(Biomes.WARPED_FOREST),
                        biomes.getOrThrow(Biomes.FROZEN_PEAKS),
                        biomes.getOrThrow(Biomes.FROZEN_RIVER),
                        biomes.getOrThrow(Biomes.JAGGED_PEAKS),
                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP),
                        biomes.getOrThrow(Biomes.MUSHROOM_FIELDS),
                        biomes.getOrThrow(Biomes.NETHER_WASTES),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_PINE_TAIGA),
                        biomes.getOrThrow(Biomes.OLD_GROWTH_SPRUCE_TAIGA),
                        biomes.getOrThrow(Biomes.SAVANNA_PLATEAU),
                        biomes.getOrThrow(Biomes.SMALL_END_ISLANDS),
                        biomes.getOrThrow(Biomes.SNOWY_PLAINS),
                        biomes.getOrThrow(Biomes.SNOWY_SLOPES),
                        biomes.getOrThrow(Biomes.SNOWY_TAIGA),
                        biomes.getOrThrow(Biomes.SOUL_SAND_VALLEY),
                        biomes.getOrThrow(Biomes.SPARSE_JUNGLE),
                        biomes.getOrThrow(Biomes.STONY_PEAKS),
                        biomes.getOrThrow(Biomes.STONY_SHORE),
                        biomes.getOrThrow(Biomes.SUNFLOWER_PLAINS),
                        biomes.getOrThrow(Biomes.THE_END),
                        biomes.getOrThrow(Biomes.WINDSWEPT_FOREST),
                        biomes.getOrThrow(Biomes.WINDSWEPT_HILLS),
                        biomes.getOrThrow(Biomes.WINDSWEPT_SAVANNA),
                        biomes.getOrThrow(Biomes.WINDSWEPT_GRAVELLY_HILLS),
                        biomes.getOrThrow(Biomes.WOODED_BADLANDS),
                        biomes.getOrThrow(Biomes.FLOWER_FOREST)),
                HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.SPEED_UPGRADER_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(UpgradesMod.MOD_ID, name));
    }
}

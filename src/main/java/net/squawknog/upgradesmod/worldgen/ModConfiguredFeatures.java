package net.squawknog.upgradesmod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.squawknog.upgradesmod.UpgradesMod;
import net.squawknog.upgradesmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUCK_UPGRADER_KEY = registerKey("luck_upgrader");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SATURATION_UPGRADER_KEY = registerKey("saturation_upgrader");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, LUCK_UPGRADER_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.LUCK_UPGRADER.get().defaultBlockState())
                ));

        register(context, SATURATION_UPGRADER_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.SATURATION_UPGRADER.get().defaultBlockState())
                ));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(UpgradesMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

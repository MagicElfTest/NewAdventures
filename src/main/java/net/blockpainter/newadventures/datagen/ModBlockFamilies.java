package net.blockpainter.newadventures.datagen;

import com.google.common.collect.Maps;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.item.ModItems;
import net.minecraft.data.BlockFamilies;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.stream.Stream;


public class ModBlockFamilies extends BlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();

    public static final BlockFamily YIRA = familyBuilder(ModBlocks.YIRA_PLANKS.get())
            .stairs(ModBlocks.YIRA_STAIRS.get())
            .button(ModBlocks.YIRA_BUTTON.get())
            .fence(ModBlocks.YIRA_FENCE.get())
            .fenceGate(ModBlocks.YIRA_FENCE_GATE.get())
            .door(ModBlocks.YIRA_DOOR.get())
            .pressurePlate(ModBlocks.YIRA_PRESSURE_PLATE.get())
            .slab(ModBlocks.YIRA_SLAB.get())
            .trapdoor(ModBlocks.YIRA_TRAPDOOR.get())


            .getFamily();

    private static BlockFamily.Builder familyBuilder(Block pBaseBlock) {
        BlockFamily.Builder blockfamily$builder = new BlockFamily.Builder(pBaseBlock);
        BlockFamily blockfamily = MAP.put(pBaseBlock, blockfamily$builder.getFamily());
        if (blockfamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(pBaseBlock));
        } else {
            return blockfamily$builder;
        }
    }
    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}

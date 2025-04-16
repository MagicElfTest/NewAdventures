package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, NewAdventures.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(BlockTags.FENCES).add(BlockInit.YIRA_FENCE.get());


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(BlockInit.YIRA_WOOD.get())
                .add(BlockInit.YIRA_LOG.get())
                .add(BlockInit.STRIPPED_YIRA_LOG.get())
                .add(BlockInit.STRIPPED_YIRA_WOOD.get())
                .add(BlockInit.YIRA_PLANKS.get());
    }
}
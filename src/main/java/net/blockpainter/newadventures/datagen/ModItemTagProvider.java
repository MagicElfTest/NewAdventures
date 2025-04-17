package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, NewAdventures.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.YIRA_WOOD.get().asItem())
                .add(ModBlocks.YIRA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_YIRA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_YIRA_WOOD.get().asItem());

        this.tag(ItemTags.LOGS)
                .add(ModBlocks.YIRA_WOOD.get().asItem())
                .add(ModBlocks.YIRA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_YIRA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_YIRA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.YIRA_PLANKS.get().asItem());
    }
}

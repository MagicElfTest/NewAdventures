package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags() , pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.YIRA_LOG.get());
        dropSelf(ModBlocks.YIRA_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_YIRA_LOG.get());
        dropSelf(ModBlocks.STRIPPED_YIRA_WOOD.get());
        dropSelf(ModBlocks.YIRA_PLANKS.get());
        dropSelf(ModBlocks.YIRA_FENCE.get());
        dropSelf(ModBlocks.YIRA_FENCE_GATE.get());
        dropSelf(ModBlocks.YIRA_BUTTON.get());
        dropSelf(ModBlocks.YIRA_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.YIRA_TRAPDOOR.get());
        dropSelf(ModBlocks.YIRA_STAIRS.get());
        this.add(ModBlocks.YIRA_SLAB.get(), x -> createSlabItemTable(ModBlocks.YIRA_SLAB.get()));
        this.add(ModBlocks.YIRA_DOOR.get(), x -> createDoorTable(ModBlocks.YIRA_DOOR.get()));
        dropSelf(ModBlocks.YIRA_SAPLING.get());
        this.add(ModBlocks.YIRA_LEAVES.get(), createLeavesDrops(ModBlocks.YIRA_LEAVES.get(), ModBlocks.YIRA_SAPLING.get(), 0.0125f));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item pItem, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(pItem)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        var blocks = ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
        System.out.println("Known blocks: " + blocks);
        return blocks;
    }
}


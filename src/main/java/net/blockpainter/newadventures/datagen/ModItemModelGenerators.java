package net.blockpainter.newadventures.datagen;

import net.blockpainter.newadventures.item.ModItems;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiConsumer;

public class ModItemModelGenerators extends ItemModelGenerators {
    public ModItemModelGenerators(ItemModelOutput pItemModelOutput, BiConsumer<ResourceLocation, ModelInstance> pModelOutput) {
        super(pItemModelOutput, pModelOutput);
    }

    @Override
    public void run() {
        generateFlatItem(ModItems.SCROLL.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.YIRA_BOAT.get(), ModelTemplates.FLAT_ITEM);
        generateFlatItem(ModItems.YIRA_CHEST_BOAT.get(), ModelTemplates.FLAT_ITEM);


        if (this.itemModelOutput instanceof ModModelProvider.ModItemInfoCollector collector)
            collector.generateDefaultBlockModels();
    }
}

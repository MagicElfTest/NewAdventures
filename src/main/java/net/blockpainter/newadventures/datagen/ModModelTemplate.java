package net.blockpainter.newadventures.datagen;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Streams;
import com.google.gson.JsonObject;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.blocks.ModFlammableRotatedPillarBlock;
import net.minecraft.client.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ModModelTemplate extends ModelTemplate {
    private final Optional<ResourceLocation> model;
    private final Set<TextureSlot> requiredSlots;
    private final Optional<String> suffix;

    public ModModelTemplate(Optional<ResourceLocation> pModel, Optional<String> pSuffix, TextureSlot... pRequiredSlots) {
        super(pModel, pSuffix, pRequiredSlots);
        this.model = pModel;
        this.suffix = pSuffix;
        this.requiredSlots = ImmutableSet.copyOf(pRequiredSlots);
    }
    public ResourceLocation create(Block pBlock, TextureMapping pTextureMapping, BiConsumer<ResourceLocation, ModelInstance> pOutput) {
        if (pBlock instanceof DoorBlock || pBlock instanceof TrapDoorBlock || pBlock instanceof SaplingBlock)
            return this.createDoor(ModelLocationUtils.getModelLocation(pBlock, this.suffix.orElse("")), pTextureMapping, pOutput);
        ResourceLocation id = ForgeRegistries.BLOCKS.getKey(pBlock);
        boolean isWoodLog = id != null
                && id.getPath().toLowerCase(Locale.ROOT).endsWith("_wood");


        if((pBlock instanceof RotatedPillarBlock || pBlock instanceof ModFlammableRotatedPillarBlock) && (!isWoodLog)) {
            return this.createPillar(ModelLocationUtils.getModelLocation(pBlock, this.suffix.orElse("")), pTextureMapping, pOutput);
        }
        if(pBlock instanceof RotatedPillarBlock || pBlock instanceof ModFlammableRotatedPillarBlock) {
            return this.createWOOD(ModelLocationUtils.getModelLocation(pBlock, this.suffix.orElse("")), pTextureMapping, pOutput);
        }
        return this.create(ModelLocationUtils.getModelLocation(pBlock, this.suffix.orElse("")), pTextureMapping, pOutput);
    }
    public ResourceLocation create(ResourceLocation pModelLocation, TextureMapping pTextureMapping, BiConsumer<ResourceLocation, ModelInstance> pOutput) {
        Map<TextureSlot, ResourceLocation> map = this.createMap(pTextureMapping);
        pOutput.accept(pModelLocation, () -> {
            JsonObject jsonobject = new JsonObject();
            this.model.ifPresent(p_376687_ -> jsonobject.addProperty("parent", p_376687_.toString()));
            if (!map.isEmpty()) {
                JsonObject jsonobject1 = new JsonObject();
                map.forEach((p_375899_, p_377821_) -> jsonobject1.addProperty(p_375899_.getId(), p_377821_.toString()));
                jsonobject.add("textures", jsonobject1);
            }
            return jsonobject;
        });
        return pModelLocation;
    }
    public ResourceLocation createDoor(ResourceLocation pModelLocation, TextureMapping pTextureMapping, BiConsumer<ResourceLocation, ModelInstance> pOutput) {
        Map<TextureSlot, ResourceLocation> map = this.createMap(pTextureMapping);
        pOutput.accept(pModelLocation, () -> {
            JsonObject jsonobject = new JsonObject();
            this.model.ifPresent(p_376687_ -> jsonobject.addProperty("parent", p_376687_.toString()));
            if (!map.isEmpty()) {
                JsonObject jsonobject1 = new JsonObject();
                map.forEach((p_375899_, p_377821_) -> jsonobject1.addProperty(p_375899_.getId(), p_377821_.toString()));
                jsonobject.add("textures", jsonobject1);
            }
            return jsonobject;
        });
        return pModelLocation;
    }
    public ResourceLocation createPillar(ResourceLocation modelLocation,
                                         TextureMapping textureMapping,
                                         BiConsumer<ResourceLocation, ModelInstance> output) {
        // Extrahiere die beiden nötigen Slots
        ResourceLocation side = textureMapping.get(TextureSlot.SIDE);
        ResourceLocation end  = textureMapping.get(TextureSlot.END);

        // Gib das Model aus
        output.accept(modelLocation, () -> {
            JsonObject root = new JsonObject();
            // Parent auf cube_column festlegen
            root.addProperty("parent", "minecraft:block/cube_column");

            // Texturen-Objekt bauen
            JsonObject textures = new JsonObject();
            textures.addProperty("end",  end.toString());
            textures.addProperty("side", side.toString());

            root.add("textures", textures);
            return root;
        });



        return modelLocation;
    }

    public ResourceLocation createWOOD(ResourceLocation modelLocation,
                                         TextureMapping textureMapping,
                                         BiConsumer<ResourceLocation, ModelInstance> output) {
        // Extrahiere die beiden nötigen Slots
        ResourceLocation side  = textureMapping.get(TextureSlot.SIDE);

        // Gib das Model aus
        output.accept(modelLocation, () -> {
            JsonObject root = new JsonObject();
            // Parent auf cube_column festlegen
            root.addProperty("parent", "minecraft:block/cube_column");

            // Texturen-Objekt bauen
            JsonObject textures = new JsonObject();
            textures.addProperty("end",  side.toString());
            textures.addProperty("side", side.toString());

            root.add("textures", textures);
            return root;
        });



        return modelLocation;
    }
    private Map<TextureSlot, ResourceLocation> createMap(TextureMapping pTextureMapping) {
        return Streams.concat(this.requiredSlots.stream(), pTextureMapping.getForced()).collect(ImmutableMap.toImmutableMap(Function.identity(), pTextureMapping::get));
    }
}

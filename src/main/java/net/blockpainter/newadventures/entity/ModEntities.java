package net.blockpainter.newadventures.entity;


import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.entity.custom.ModBoatEntity;
import net.blockpainter.newadventures.entity.custom.ModChestBoatEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.AbstractBoat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.Keys.ENTITY_TYPES;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NewAdventures.MODID);

    public static final RegistryObject<EntityType<ModBoatEntity>> YIRA_BOAT =
            ENTITY_TYPES.register("yira_boat", () ->
                    EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .build(ResourceKey.create(
                                    Registries.ENTITY_TYPE,
                                    ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_boat")
                            )));
    public static final RegistryObject<EntityType<ModChestBoatEntity>> YIRA_CHEST_BOAT =
            ENTITY_TYPES.register("yira_chest_boat", () ->
                    EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F)
                            .build(ResourceKey.create(
                                    Registries.ENTITY_TYPE,
                                    ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_chest_boat")
                            )));
}
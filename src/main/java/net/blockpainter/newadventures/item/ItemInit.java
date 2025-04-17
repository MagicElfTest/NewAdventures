package net.blockpainter.newadventures.item;

import net.blockpainter.newadventures.NewAdventures;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit{




    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NewAdventures.MODID);

    public static final RegistryObject<Item> SCROLL = ITEMS.register("scroll",
            () -> new Item(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "scroll")))
            ));

    /*public static final RegistryObject<Item> PINE_BOAT = ITEMS.register("pine_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.PINE, new Item.Properties()));
    public static final RegistryObject<Item> PINE_CHEST_BOAT = ITEMS.register("pine_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.PINE, new Item.Properties()));*/


    //public static final RegistryObject<BoatItem> YIRA_BOAT = ITEMS.register("yira_boat", () -> new BoatItem(ModEntities.YIRA_BOAT.get(), new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_boat")))));

    /*public static final RegistryObject<Item> YIRA_BOAT = ITEMS.register("yira_boat",
            () -> new YiraBoatItem(ModEntities.YIRA_BOAT, YiraBoatType.YIRA,
                    new Item.Properties().stacksTo(1).setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_boat"))))
    );*/
}



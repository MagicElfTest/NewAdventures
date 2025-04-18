package net.blockpainter.newadventures.event;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.entity.client.ModModelLayers;
import net.minecraft.client.model.BoatModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NewAdventures.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PINE_BOAT_LAYER, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.PINE_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
    }
}

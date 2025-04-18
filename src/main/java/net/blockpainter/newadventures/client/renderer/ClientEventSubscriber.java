package net.blockpainter.newadventures.client.renderer;

/*import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.entity.ModEntities;
import net.minecraft.client.model.BoatModel;                             // ← Mojang mappings // ← Mojang mappings
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;






@Mod.EventBusSubscriber(modid = NewAdventures.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventSubscriber {
    public static final ModelLayerLocation YIRA_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_boat"), "main");
    public static final ModelLayerLocation YIRA_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_chest_boat"), "main");


    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        // use getTexturedModelData() instead of the missing createBodyModel()
        evt.registerLayerDefinition(YIRA_BOAT_LAYER,  BoatModel::getTexturedModelData);       :contentReference[oaicite:0]{index=0}
        evt.registerLayerDefinition(YIRA_CHEST_BOAT_LAYER, ChestBoatModel::getTexturedModelData); :contentReference[oaicite:1]{index=1}
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers evt) {
        evt.registerEntityRenderer(ModEntities.YIRA_BOAT.get(),
                ctx -> new BoatRenderer(ctx, YIRA_BOAT_LAYER));
        evt.registerEntityRenderer(ModEntities.YIRA_CHEST_BOAT.get(),
                ctx -> new BoatRenderer(ctx, YIRA_CHEST_BOAT_LAYER));
    }
}*/

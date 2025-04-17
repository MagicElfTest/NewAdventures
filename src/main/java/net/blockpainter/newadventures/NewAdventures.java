package net.blockpainter.newadventures;

import com.mojang.logging.LogUtils;
import net.blockpainter.newadventures.creativetab.CreativeTabInit;
import net.blockpainter.newadventures.item.ModItems;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(NewAdventures.MODID)
public class NewAdventures {

    public static final String MODID = "newadventures";

    public static final Logger LOGGER = LogUtils.getLogger();


    //public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public NewAdventures(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.register(modEventBus);

        CreativeTabInit.register(modEventBus);
    }

}

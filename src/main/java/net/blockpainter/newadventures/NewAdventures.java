package net.blockpainter.newadventures;

import net.blockpainter.newadventures.creativetab.CreativeTabInit;
import net.blockpainter.newadventures.item.ItemInit;
import net.blockpainter.newadventures.blocks.BlockInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NewAdventures.MODID)
public class NewAdventures {

    public static final String MODID = "newadventures";

    //private static final Logger LOGGER = LogUtils.getLogger();


    //public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public NewAdventures(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);

        ItemInit.ITEMS.register(modEventBus);
        BlockInit.register(modEventBus);

        CreativeTabInit.register(modEventBus);
    }



}

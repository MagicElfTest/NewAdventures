package net.blockpainter.newadventures;

import com.mojang.logging.LogUtils;
import net.blockpainter.newadventures.init.ItemInit;
import net.minecraft.advancements.Advancement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.minecraftforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(NewAdventures.MODID)
public class NewAdventures {

    public static final String MODID = "newadventures";

    //private static final Logger LOGGER = LogUtils.getLogger();


    //public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public NewAdventures(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        ItemInit.ITEMS.register(modEventBus);

    }

}

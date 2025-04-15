package net.blockpainter.newadventures.creativetab;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.item.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NewAdventures.MODID);

    //For Later
    /*public static final RegistryObject<CreativeModeTab> NA_MISC_TAB = CREATIVE_MODE_TAB.register("na_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockInit.YIRA_LOG.get()))
                    .title(Component.translatable("creativetab.newadventures.misc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BlockInit.YIRA_LOG.get());
                        output.accept(BlockInit.YIRA_PLANK.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }*/

    public static final RegistryObject<CreativeModeTab> NA_SCROLL_TAB = CREATIVE_MODE_TAB.register("na_scroll_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.SCROLL.get()))
                    .title(Component.translatable("creativetab.newadventures.scroll_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemInit.SCROLL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
package net.blockpainter.newadventures.creativetab;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.BlockInit;
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

    public static final RegistryObject<CreativeModeTab> NA_MISC_TAB = CREATIVE_MODE_TAB.register("na_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockInit.YIRA_LOG.get()))
                    .title(Component.translatable("creativetab.newadventures.misc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(BlockInit.YIRA_LOG.get());
                        output.accept(BlockInit.STRIPPED_YIRA_LOG.get());
                        output.accept(BlockInit.YIRA_WOOD.get());
                        output.accept(BlockInit.STRIPPED_YIRA_WOOD.get());
                        output.accept(BlockInit.YIRA_PLANKS.get());
                        output.accept(BlockInit.YIRA_FENCE_GATE.get());
                        output.accept(BlockInit.YIRA_FENCE.get());
                        output.accept(BlockInit.YIRA_PRESSURE_PLATE.get());
                        output.accept(BlockInit.YIRA_DOOR.get());
                        output.accept(BlockInit.YIRA_TRAPDOOR.get());
                        output.accept(BlockInit.YIRA_SLAB.get());
                        output.accept(BlockInit.YIRA_STAIRS.get());
                        output.accept(BlockInit.YIRA_BUTTON.get());

                    })
                    .build());

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
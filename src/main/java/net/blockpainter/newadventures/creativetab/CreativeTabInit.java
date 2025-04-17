package net.blockpainter.newadventures.creativetab;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.ModBlocks;
import net.blockpainter.newadventures.item.ModItems;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.YIRA_LOG.get()))
                    .title(Component.translatable("creativetab.newadventures.misc_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.YIRA_LOG.get());
                        output.accept(ModBlocks.STRIPPED_YIRA_LOG.get());
                        output.accept(ModBlocks.YIRA_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_YIRA_WOOD.get());
                        output.accept(ModBlocks.YIRA_PLANKS.get());
                        output.accept(ModBlocks.YIRA_FENCE_GATE.get());
                        output.accept(ModBlocks.YIRA_FENCE.get());
                        output.accept(ModBlocks.YIRA_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.YIRA_DOOR.get());
                        output.accept(ModBlocks.YIRA_SLAB.get());
                        output.accept(ModBlocks.YIRA_STAIRS.get());

                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> NA_SCROLL_TAB = CREATIVE_MODE_TAB.register("na_scroll_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCROLL.get()))
                    .title(Component.translatable("creativetab.newadventures.scroll_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SCROLL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
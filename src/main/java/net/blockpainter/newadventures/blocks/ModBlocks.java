package net.blockpainter.newadventures.blocks;

import net.blockpainter.newadventures.NewAdventures;
import net.blockpainter.newadventures.blocks.custom.ModSaplingBlock;
import net.blockpainter.newadventures.worldgen.tree.ModTreeGrowers;
import net.blockpainter.newadventures.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final BlockSetType YIRA_BLOCKSETTYPE = BlockSetType.register(new BlockSetType(
            "YIRA",
            true,
            true,
            true,
            BlockSetType.PressurePlateSensitivity.EVERYTHING,
            SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE,
            SoundEvents.WOODEN_DOOR_OPEN,
            SoundEvents.WOODEN_TRAPDOOR_CLOSE,
            SoundEvents.WOODEN_TRAPDOOR_OPEN,
            SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.WOODEN_BUTTON_CLICK_OFF,
            SoundEvents.WOODEN_BUTTON_CLICK_ON));

    public static final WoodType YIRA_WOODTYPE = WoodType.register(new WoodType("yira", BlockSetType.register(YIRA_BLOCKSETTYPE)));

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NewAdventures.MODID);

    //Yira Wood
    public static final RegistryObject<Block> YIRA_LOG = registerBlock("yira_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_log")))));
    public static final RegistryObject<Block> YIRA_WOOD = registerBlock("yira_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_wood")))));

    public static final RegistryObject<Block> STRIPPED_YIRA_LOG = registerBlock("stripped_yira_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "stripped_yira_log")))));
    public static final RegistryObject<Block> STRIPPED_YIRA_WOOD = registerBlock("stripped_yira_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "stripped_yira_wood")))));

    public  static  final RegistryObject<Block> YIRA_PLANKS = registerBlock("yira_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_planks")))) {

                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
    });

    public static final RegistryObject<StairBlock> YIRA_STAIRS = registerBlock("yira_stairs",
            () -> new StairBlock(ModBlocks.YIRA_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_stairs"))))
            );

    public static final RegistryObject<SlabBlock> YIRA_SLAB = registerBlock("yira_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_slab"))))
            );

    public static final RegistryObject<Block> YIRA_DOOR = registerBlock("yira_door",
            () -> new DoorBlock(BlockSetType.register(YIRA_BLOCKSETTYPE),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_door"))))
            );
    public static final RegistryObject<Block> YIRA_TRAPDOOR = registerBlock("yira_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.register(YIRA_BLOCKSETTYPE),
                    BlockBehaviour.Properties.of().noOcclusion().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_trapdoor"))))
    );

    public static final RegistryObject<Block> YIRA_PRESSURE_PLATE = registerBlock("yira_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.register(YIRA_BLOCKSETTYPE),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_pressure_plate"))))
            );

    public static final RegistryObject<Block> YIRA_BUTTON = registerBlock("yira_button",
            () -> new ButtonBlock(BlockSetType.register(YIRA_BLOCKSETTYPE), 10,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)
                            .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_button"))))
    );

    public static final RegistryObject<Block> YIRA_FENCE = registerBlock("yira_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
                   .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_fence"))))
    );

    public static final RegistryObject<Block> YIRA_FENCE_GATE = registerBlock("yira_fence_gate",
            () -> new FenceGateBlock(WoodType.register(YIRA_WOODTYPE), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(ResourceKey.create((Registries.BLOCK), ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_fence_gate"))))
    );

    public static final RegistryObject<Block> YIRA_LEAVES = registerBlock("yira_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_leaves")))) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final RegistryObject<Block> YIRA_SAPLING = registerBlock("yira_sapling",
            () -> new ModSaplingBlock(ModTreeGrowers.YIRA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noOcclusion().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, "yira_sapling"))), () -> Blocks.END_STONE));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private  static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(NewAdventures.MODID, name)))));
    }




    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

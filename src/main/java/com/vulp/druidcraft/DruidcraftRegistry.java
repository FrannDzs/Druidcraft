package com.vulp.druidcraft;

import com.vulp.druidcraft.blocks.HempBlock;
import com.vulp.druidcraft.blocks.OreBlock;
import com.vulp.druidcraft.blocks.SaplingBlock;
import com.vulp.druidcraft.blocks.trees.DarkwoodTree;
import com.vulp.druidcraft.items.PlantableItem;
import com.vulp.druidcraft.registry.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class DruidcraftRegistry {

    public static final String MODID = "druidcraft";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ItemGroup DRUIDCRAFT = new DruidcraftItemGroup();

    // ITEM REGISTRATION
    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent)
    {
        itemRegistryEvent.getRegistry().registerAll
                (
                        // True items:
                        ItemRegistry.hemp = new Item(new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("hemp")),
                        ItemRegistry.hemp_seeds = new PlantableItem(new Item.Properties().group(DRUIDCRAFT), PlantType.Crop, BlockRegistry.hemp_crop).setRegistryName(location("hemp_seeds")),
                        ItemRegistry.amber = new Item(new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("amber")),
                        ItemRegistry.moonstone = new Item(new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("moonstone")),
                        ItemRegistry.fiery_glass = new Item(new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("fiery_glass")),
                        ItemRegistry.rockroot = new Item(new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("rockroot")),

                        //Tools & Armour:
                        ItemRegistry.bone_sword = new SwordItem(ToolMaterialRegistry.bone, 3, -2.4f, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_sword")),
                        ItemRegistry.bone_shovel = new ShovelItem(ToolMaterialRegistry.bone, 1.5f, -3.0f, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_shovel")),
                        ItemRegistry.bone_pickaxe = new PickaxeItem(ToolMaterialRegistry.bone, 1, -2.8f, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_pickaxe")),
                        ItemRegistry.bone_axe = new AxeItem(ToolMaterialRegistry.bone, 7.0f, -3.2f, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_axe")),
                        ItemRegistry.bone_hoe = new HoeItem(ToolMaterialRegistry.bone, -2.0f, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_hoe")),

                        ItemRegistry.bone_helmet = new ArmorItem(ArmorMaterialRegistry.bone, EquipmentSlotType.HEAD, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_helmet")),
                        ItemRegistry.bone_chestplate = new ArmorItem(ArmorMaterialRegistry.bone, EquipmentSlotType.CHEST, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_chestplate")),
                        ItemRegistry.bone_leggings = new ArmorItem(ArmorMaterialRegistry.bone, EquipmentSlotType.LEGS, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_leggings")),
                        ItemRegistry.bone_boots = new ArmorItem(ArmorMaterialRegistry.bone, EquipmentSlotType.FEET, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(location("bone_boots")),

                        // Item-blocks:
                        ItemRegistry.hemp_crop = new BlockItem(BlockRegistry.hemp_crop, new Item.Properties()).setRegistryName(BlockRegistry.hemp_crop.getRegistryName()),
                        ItemRegistry.amber_ore = new BlockItem(BlockRegistry.amber_ore, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.amber_ore.getRegistryName()),
                        ItemRegistry.moonstone_ore = new BlockItem(BlockRegistry.moonstone_ore, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.moonstone_ore.getRegistryName()),
                        ItemRegistry.fiery_glass_ore = new BlockItem(BlockRegistry.fiery_glass_ore, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.fiery_glass_ore.getRegistryName()),
                        ItemRegistry.rockroot_ore = new BlockItem(BlockRegistry.rockroot_ore, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.rockroot_ore.getRegistryName()),
                        ItemRegistry.darkwood_log = new BlockItem(BlockRegistry.darkwood_log, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.darkwood_log.getRegistryName()),
                        ItemRegistry.stripped_darkwood_log = new BlockItem(BlockRegistry.stripped_darkwood_log, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.stripped_darkwood_log.getRegistryName()),
                        ItemRegistry.darkwood_leaves = new BlockItem(BlockRegistry.darkwood_leaves, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.darkwood_leaves.getRegistryName()),
                        ItemRegistry.darkwood_sapling = new BlockItem(BlockRegistry.darkwood_sapling, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.darkwood_sapling.getRegistryName()),
                        ItemRegistry.darkwood_planks = new BlockItem(BlockRegistry.darkwood_planks, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.darkwood_planks.getRegistryName()),

                        ItemRegistry.oak_beam = new BlockItem(BlockRegistry.oak_beam, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.oak_beam.getRegistryName()),
                        ItemRegistry.spruce_beam = new BlockItem(BlockRegistry.spruce_beam, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.spruce_beam.getRegistryName()),
                        ItemRegistry.birch_beam = new BlockItem(BlockRegistry.birch_beam, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.birch_beam.getRegistryName()),
                        ItemRegistry.jungle_beam = new BlockItem(BlockRegistry.jungle_beam, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.jungle_beam.getRegistryName()),
                        ItemRegistry.acacia_beam = new BlockItem(BlockRegistry.acacia_beam, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.acacia_beam.getRegistryName()),
                        ItemRegistry.dark_oak_beam = new BlockItem(BlockRegistry.dark_oak_beam, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.dark_oak_beam.getRegistryName()),
                        ItemRegistry.darkwood_beam = new BlockItem(BlockRegistry.darkwood_beam, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.darkwood_beam.getRegistryName()),

                        ItemRegistry.oak_panels = new BlockItem(BlockRegistry.oak_panels, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.oak_panels.getRegistryName()),
                        ItemRegistry.spruce_panels = new BlockItem(BlockRegistry.spruce_panels, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.spruce_panels.getRegistryName()),
                        ItemRegistry.birch_panels = new BlockItem(BlockRegistry.birch_panels, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.birch_panels.getRegistryName()),
                        ItemRegistry.jungle_panels = new BlockItem(BlockRegistry.jungle_panels, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.jungle_panels.getRegistryName()),
                        ItemRegistry.acacia_panels = new BlockItem(BlockRegistry.acacia_panels, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.acacia_panels.getRegistryName()),
                        ItemRegistry.dark_oak_panels = new BlockItem(BlockRegistry.dark_oak_panels, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.dark_oak_panels.getRegistryName()),
                        ItemRegistry.darkwood_panels = new BlockItem(BlockRegistry.darkwood_panels, new Item.Properties().group(DRUIDCRAFT)).setRegistryName(BlockRegistry.darkwood_panels.getRegistryName())
                );
        LOGGER.info("Items registered.");
    }

    // BLOCK REGISTRATION
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> BlockRegistryEvent)
    {
        BlockRegistryEvent.getRegistry().registerAll
                (
                        BlockRegistry.hemp_crop = new HempBlock(HempBlock.Properties.create(Material.PLANTS).sound(SoundType.CROP).hardnessAndResistance(0.0f).doesNotBlockMovement().tickRandomly()).setRegistryName(location("hemp_crop")),
                        BlockRegistry.amber_ore = new OreBlock(OreBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1), 3, 6).setRegistryName(location("amber_ore")),
                        BlockRegistry.moonstone_ore = new OreBlock(OreBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2), 3, 7).setRegistryName(location("moonstone_ore")),
                        BlockRegistry.fiery_glass_ore = new OreBlock(OreBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2), 2, 5).setRegistryName(location("fiery_glass_ore")),
                        BlockRegistry.rockroot_ore = new OreBlock(OreBlock.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.PICKAXE).harvestLevel(0), 1, 5).setRegistryName(location("rockroot_ore")),
                        BlockRegistry.darkwood_log = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("darkwood_log")),
                        BlockRegistry.stripped_darkwood_log = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("stripped_darkwood_log")),
                        BlockRegistry.darkwood_leaves = new LeavesBlock(LeavesBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)).setRegistryName(location("darkwood_leaves")),
                        BlockRegistry.darkwood_sapling = new SaplingBlock(new DarkwoodTree(), SaplingBlock.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f, 5.0f)).setRegistryName(location("darkwood_sapling")),
                        BlockRegistry.darkwood_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("darkwood_planks")),

                        BlockRegistry.oak_beam = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("oak_beam")),
                        BlockRegistry.spruce_beam = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("spruce_beam")),
                        BlockRegistry.birch_beam = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("birch_beam")),
                        BlockRegistry.jungle_beam = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("jungle_beam")),
                        BlockRegistry.acacia_beam = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("acacia_beam")),
                        BlockRegistry.dark_oak_beam = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("dark_oak_beam")),
                        BlockRegistry.darkwood_beam = new RotatedPillarBlock(RotatedPillarBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("darkwood_beam")),

                        BlockRegistry.oak_panels = new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("oak_panels")),
                        BlockRegistry.spruce_panels = new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("spruce_panels")),
                        BlockRegistry.birch_panels = new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("birch_panels")),
                        BlockRegistry.jungle_panels = new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("jungle_panels")),
                        BlockRegistry.acacia_panels = new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("acacia_panels")),
                        BlockRegistry.dark_oak_panels = new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("dark_oak_panels")),
                        BlockRegistry.darkwood_panels = new Block(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(3.0f, 5.0f).harvestTool(ToolType.AXE)).setRegistryName(location("darkwood_panels"))
                );
        LOGGER.info("Blocks registered.");
    }

    public static ResourceLocation location(String name)
    {
        return new ResourceLocation(MODID, name);
    }
}
package org.ecorous.fruitsandforests.registry

import net.minecraft.block.Block
import net.minecraft.block.MapColor
import net.minecraft.block.Material
import net.minecraft.block.PillarBlock
import net.minecraft.item.BlockItem
import net.minecraft.registry.Registries
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.math.Direction
import org.ecorous.fruitsandforests.FruitsAndForests
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings
import org.quiltmc.qkl.library.registry.*
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings

object FNFBlocks {
    private var BLOCKS = mutableMapOf<Identifier, Block>()
    private fun createLogBlock(id: String, uprightColor: MapColor, sidewaysColor: MapColor) {
        BLOCKS[FruitsAndForests.id(id)] = logBlock(uprightColor, sidewaysColor)
    }
    private fun logBlock(uprightColor: MapColor, sidewaysColor: MapColor): PillarBlock {
        return PillarBlock(QuiltBlockSettings.of(Material.WOOD)
            { state -> if (state.get(PillarBlock.AXIS) == Direction.Axis.Y) uprightColor else sidewaysColor}
            .strength(2.0F, 3.0F)
            .sounds(BlockSoundGroup.WOOD))
    }
    private fun createPlanksBlock(id: String, mapColor: MapColor): Block {
        BLOCKS[FruitsAndForests.id(id)] = planksBlock(mapColor)
        return BLOCKS[FruitsAndForests.id(id)]!!
    }
    private fun planksBlock(mapColor: MapColor): Block {
        return Block(QuiltBlockSettings.of(Material.WOOD, mapColor)
            .strength(2.0F, 3.0F)
            .sounds(BlockSoundGroup.WOOD))
    }

    // Almond
    val almondLog = createLogBlock("almond_log", MapColor.TERRACOTTA_YELLOW, MapColor.BROWN)
    val almondPlanks = createPlanksBlock("almond_planks", MapColor.TERRACOTTA_YELLOW)

    fun doRegistry() {
        Registries.BLOCK {
            BLOCKS.forEach { (id, block) ->
                block withId id
            }
        }
        Registries.ITEM {
            BLOCKS.forEach { (id, block) ->
                BlockItem(block, QuiltItemSettings()) withId id
            }
        }
    }
}

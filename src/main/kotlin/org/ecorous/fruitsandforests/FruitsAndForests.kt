package org.ecorous.fruitsandforests

import net.minecraft.util.Identifier
import org.ecorous.fruitsandforests.registry.FNFBlocks
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object FruitsAndForests : ModInitializer {
    val LOGGER: Logger = LoggerFactory.getLogger("FruitsAndForests")
    val MODID = "fruitsandforests"
    fun id(id: String): Identifier {
        return Identifier(MODID, id)
    }
    override fun onInitialize(mod: ModContainer) {
        LOGGER.info("Hello Quilt world from {}!", mod.metadata()?.name())
        FNFBlocks.doRegistry()
    }
}

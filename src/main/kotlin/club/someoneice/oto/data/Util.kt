package club.someoneice.oto.data

import cpw.mods.fml.common.registry.GameRegistry
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.world.World


object Util {
    fun findEntity(world: World): MutableList<Any?>? {
        return world.getLoadedEntityList()
    }

    fun getModIdFromBlock(block: Block): String {
        return GameRegistry.findUniqueIdentifierFor(block).modId ?: "null"
    }

    fun getRegisterNameFromBlock(block: Block): String {
        val modId: String? = GameRegistry.findUniqueIdentifierFor(block).modId
        val blockRegistryName: String? = GameRegistry.findUniqueIdentifierFor(block).name
        return if (modId != null && blockRegistryName != null)
            "$modId.$blockRegistryName"
        else "null"
    }

    fun getModIdFromItem(item: Item): String {
        return GameRegistry.findUniqueIdentifierFor(item).modId ?: "null"
    }

    fun getRegisterNameFromItem(item: Item): String {
        val modId: String? = GameRegistry.findUniqueIdentifierFor(item).modId
        val itemRegistryName: String? = GameRegistry.findUniqueIdentifierFor(item).name
        return if (modId != null && itemRegistryName != null)
            "$modId.$itemRegistryName"
        else "null"
    }


}
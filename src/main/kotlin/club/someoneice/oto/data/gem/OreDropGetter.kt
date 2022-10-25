package club.someoneice.oto.data.gem

import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import java.util.*

object OreDropGetter {
    var ItemList: ArrayList<ItemStack>? = ArrayList<ItemStack>()
    fun OreDorpGetter(ore: Block, world: World, x: Int, y: Int, z: Int, meta: Int): HashMap<String, HashMap<Int, Double>>? {
        val dropList: HashMap<String, HashMap<Int, Double>> = HashMap<String, HashMap<Int, Double>>()
        val fortunes: HashMap<Int, Double> = HashMap<Int, Double>()
        if (ore == Blocks.air) {
            fortunes.put(0, 0.0)
            dropList.put("null", fortunes)
            return dropList
        }

        try {
            for (i in 0..3) {
                ItemList = ore.getDrops(world, x, y, z, meta, i)
                if (ItemList != null && ItemList!!.size >= 1) {
                    fortunes.put(i, ItemList!![0].stackSize.toDouble())
                } else continue
            }

            if (ItemList != null && ItemList!!.size >= 1)
                dropList.put(ItemList!![0].unlocalizedName, fortunes)
        } catch (_:NullPointerException) {
            fortunes.put(0, 0.0)
            dropList.put("null", fortunes)
            return dropList
        }

        return if (dropList.size >= 1) dropList
        else null
    }
}
package club.someoneice.oto.data.gem

import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import java.util.*

object OreDropGetter {
    var ItemList: ArrayList<ItemStack>? = ArrayList<ItemStack>()
    fun OreDorpGetter(ore: Block, world: World, x: Int, y: Int, z: Int, meta: Int): HashMap<String, HashMap<Int, Double>>? {
        val dropList: HashMap<String, HashMap<Int, Double>> = HashMap<String, HashMap<Int, Double>>()
        val fortunes: HashMap<Int, Double> = HashMap<Int, Double>()
        for (i in 0 .. 3) {
            ItemList = ore.getDrops(world, x, y, z, meta, i)
            if (ItemList != null && ItemList!!.size >= 1) {
                fortunes.put(i, ItemList!![0].stackSize.toDouble())
            } else continue
        }

        if (ItemList != null && ItemList!!.size >= 1) dropList.put(ItemList!![0].unlocalizedName, fortunes)

        return if (dropList.size >= 1) dropList
        else null
    }
}
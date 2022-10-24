package club.someoneice.oto.data.gem

import club.someoneice.oto.data.gem.helper.DropHelper
import club.someoneice.oto.data.gem.helper.OreHelper
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

object OreGetter {

    fun OreGetter(world: World, player: EntityPlayerMP, x: Int, y: Int, z: Int) {
        val od: HashMap<Int, Int> = HashMap<Int, Int>()
        val block: Block = world.getBlock(x, y, z)
        val blockMeta: Int = world.getBlockMetadata(x, y, z)
        val silk: Boolean = block.canSilkHarvest(world, player, x, y ,z, blockMeta)
        if (block == Blocks.air)
            return

        if (!Data.OreData.containsKey(block.unlocalizedName)) {
            val drop: HashMap<String, HashMap<Int, Double>>? = OreDropGetter.OreDorpGetter(block, world, x, y, z, blockMeta)
            val dropList: ArrayList<DropHelper> = ArrayList<DropHelper>()
            if (drop != null) {
                val dropSet: Set<String> = drop.keys
                val iterator: Iterator<String> = dropSet.iterator()
                while (iterator.hasNext()) {
                    val name: String = iterator.next()
                    dropList.add(DropHelper(name, drop[name]!!))
                }
            }
            od.put(y, 1)
            val DIMINFO: String = "dim " + world.provider.dimensionId + " : " + world.provider.dimensionName
            Data.OreData.put(block.unlocalizedName, OreHelper(block.unlocalizedName, od, silk, dropList, DIMINFO))
        }

        if (!Data.OreData[block.unlocalizedName]!!.ore_distrib.containsKey(y) || Data.OreData[block.unlocalizedName]!!.ore_distrib[y] == null) {
            Data.OreData[block.unlocalizedName]!!.ore_distrib.put(y, 1)
        } else {
            Data.OreData[block.unlocalizedName]!!.ore_distrib.put(y, Data.OreData[block.unlocalizedName]!!.ore_distrib[y]!! + 1)
        }
    }
}
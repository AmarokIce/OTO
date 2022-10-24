package club.someoneice.oto.data.gem

import club.someoneice.oto.data.gem.helper.CountSandman
import club.someoneice.oto.data.gem.helper.DropHelper
import club.someoneice.oto.data.gem.helper.OreHelper
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

object OreGetter {

    fun OreGetter(world: World, player: EntityPlayerMP, x: Int, y: Int, z: Int, allBlock: Int) {
        val oreCount: HashMap<String, CountSandman> = HashMap<String, CountSandman>()
        val block: Block = world.getBlock(x, y, z)
        val blockMeta: Int = world.getBlockMetadata(x, y, z)
        val silk: Boolean = block.canSilkHarvest(world, player, x, y ,z, blockMeta)
        val allBlock: Int = allBlock

        // Sandman, for init.
        val od: HashMap<Int, Double> = HashMap<Int, Double>()
        val sandman = HashMap<Int, Int>()
        sandman.put(y, 1)

        // if (block == Blocks.air)
        //     return

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
            od.put(y, 1.0)
            val DIMINFO: String = "dim " + world.provider.dimensionId + " : " + world.provider.dimensionName
            Data.OreData.put(block.unlocalizedName, OreHelper(block.unlocalizedName, od, silk, dropList, DIMINFO))
        }


        if (!oreCount.containsKey(block.unlocalizedName) || !oreCount[block.unlocalizedName]!!.countSandman.containsKey(y) || oreCount[block.unlocalizedName]!!.countSandman[y] == null) {
            oreCount.put(block.unlocalizedName, CountSandman(sandman))
            Data.OreData[block.unlocalizedName]!!.ore_distrib.put(y, (oreCount[block.unlocalizedName]!!.countSandman[y]!!.toDouble() / allBlock.toDouble()))
        } else {
            oreCount[block.unlocalizedName]!!.countSandman.put(y, oreCount[block.unlocalizedName]!!.countSandman[y]!! + 1)
            Data.OreData[block.unlocalizedName]!!.ore_distrib.put(y, (oreCount[block.unlocalizedName]!!.countSandman[y]!!.toDouble() / allBlock.toDouble()))
        }

        /*
        if (!Data.OreData[block.unlocalizedName]!!.ore_distrib.containsKey(y) || Data.OreData[block.unlocalizedName]!!.ore_distrib[y] == null) {
            Data.OreData[block.unlocalizedName]!!.ore_distrib.put(y, 1)
        } else {
            Data.OreData[block.unlocalizedName]!!.ore_distrib.put(y, Data.OreData[block.unlocalizedName]!!.ore_distrib[y]!! + 1)
        }
        */
    }
}
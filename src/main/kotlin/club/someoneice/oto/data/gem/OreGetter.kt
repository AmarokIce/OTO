package club.someoneice.oto.data.gem

import club.someoneice.oto.data.Util
import club.someoneice.oto.data.gem.helper.CountSandman
import club.someoneice.oto.data.gem.helper.DropHelper
import club.someoneice.oto.data.gem.helper.OreHelper
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.init.Blocks
import net.minecraft.world.World
import java.util.*

object OreGetter {
    fun OreGetter(world: World, player: EntityPlayerMP, x: Int, y: Int, z: Int, allBlock: Double) {
        val block: Block = world.getBlock(x, y, z)
        val blockMeta: Int = world.getBlockMetadata(x, y, z)
        val silk: Boolean = block.canSilkHarvest(world, player, x, y ,z, blockMeta)

        // Sandman, for init.
        val od: HashMap<Int, Double> = HashMap<Int, Double>()
        val sandman = HashMap<Int, Int>()
        sandman.put(y, 1)

        // if (block == Blocks.air)
        //     return

        if (!Data.OreData.containsKey(Util.getRegisterNameFromBlock(block))) {
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
            Data.OreData.put(Util.getRegisterNameFromBlock(block), OreHelper(Util.getRegisterNameFromBlock(block), od, silk, dropList, DIMINFO))
        }


        if (!Data.OreCount.containsKey(Util.getRegisterNameFromBlock(block)) || !Data.OreCount[Util.getRegisterNameFromBlock(block)]!!.countSandman.containsKey(y) || Data.OreCount[Util.getRegisterNameFromBlock(block)]!!.countSandman[y] == null) {
            Data.OreCount.put(Util.getRegisterNameFromBlock(block), CountSandman(sandman))
            Data.OreData[Util.getRegisterNameFromBlock(block)]!!.distrib.put(y, (Data.OreCount[Util.getRegisterNameFromBlock(block)]!!.countSandman[y]!!.toDouble() / allBlock))
        } else {
            Data.OreCount[Util.getRegisterNameFromBlock(block)]!!.countSandman.put(y, Data.OreCount[Util.getRegisterNameFromBlock(block)]!!.countSandman[y]!! + 1)
            Data.OreData[Util.getRegisterNameFromBlock(block)]!!.distrib.put(y, (Data.OreCount[Util.getRegisterNameFromBlock(block)]!!.countSandman[y]!!.toDouble() / allBlock))
        }

        /*
        if (!Data.OreData[Util.getRegisterNameFromBlock(block)]!!.ore_distrib.containsKey(y) || Data.OreData[Util.getRegisterNameFromBlock(block)]!!.ore_distrib[y] == null) {
            Data.OreData[Util.getRegisterNameFromBlock(block)]!!.ore_distrib.put(y, 1)
        } else {
            Data.OreData[Util.getRegisterNameFromBlock(block)]!!.ore_distrib.put(y, Data.OreData[Util.getRegisterNameFromBlock(block)]!!.ore_distrib[y]!! + 1)
        }
        */
    }
}
package club.someoneice.oto.data.helper

import net.minecraft.block.Block
import java.util.*

data class BuildHelper(
    val build: ArrayList<Block>,
    val meta: ArrayList<Int>,
    val LongX: Int,
    val LongY: Int,
    val LongZ: Int
)

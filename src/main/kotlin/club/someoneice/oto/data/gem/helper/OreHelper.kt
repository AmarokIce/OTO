package club.someoneice.oto.data.gem.helper

import java.util.*

data class OreHelper(
    var block: String,
    val distrib: HashMap<Int, Double>,
    val silktouch: Boolean,
    val dropsList: ArrayList<DropHelper>,
    var dim: String
)


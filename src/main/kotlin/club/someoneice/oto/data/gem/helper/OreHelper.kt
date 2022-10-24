package club.someoneice.oto.data.gem.helper

import java.util.*

data class OreHelper(
    var ore_name: String,
    val ore_distrib: HashMap<Int, Double>,
    val silktouch: Boolean,
    val dropsList: ArrayList<DropHelper>,
    var dim: String
)


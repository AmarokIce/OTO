package club.someoneice.oto.data.gem.helper

import java.util.*

// For make it smell like jer json.
data class JsonDataHelper(
    var block: String,
    val distrib: String,
    val silktouch: Boolean,
    val dropsList: ArrayList<DropHelper>,
    var dim: String
)

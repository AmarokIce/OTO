package club.someoneice.oto.data.gem

import club.someoneice.oto.data.gem.helper.CountSandman
import club.someoneice.oto.data.gem.helper.JsonDataHelper
import club.someoneice.oto.data.gem.helper.OreHelper
import java.util.HashMap

object Data {
    var OreData: HashMap<String, OreHelper> = HashMap<String, OreHelper>()
    val JERJsonOreData: HashMap<String, JsonDataHelper> = HashMap<String, JsonDataHelper>()
    val OreCount: HashMap<String, CountSandman> = HashMap<String, CountSandman>()
}
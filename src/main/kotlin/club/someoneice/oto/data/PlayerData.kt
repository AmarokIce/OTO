package club.someoneice.oto.data

import club.someoneice.oto.data.helper.BuildHelper
import club.someoneice.oto.data.helper.PlayerPortDataHelper
import java.util.*

open class PlayerData {
    companion object {
        val PlayerTPList: HashMap<String, String> = HashMap<String, String>()
        val PlayerGoing: HashMap<String, Boolean> = HashMap<String, Boolean>()
        val PlayerDataList: HashMap<String, PlayerDeathData> = HashMap<String, PlayerDeathData>()


        val PlayerPortList: HashMap<String, PlayerPortDataHelper> = HashMap<String, PlayerPortDataHelper>()
        val PlayerBuildList: HashMap<String, BuildHelper> = HashMap<String, BuildHelper>()
    }
}
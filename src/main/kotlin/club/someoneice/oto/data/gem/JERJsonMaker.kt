package club.someoneice.oto.data.gem

import club.someoneice.oto.data.gem.helper.JsonDataHelper

// Make json smell like JER 's json.
object JERJsonMaker {
    fun JERJsonMaker() {
        val iterator: Iterator<String> = Data.OreData.keys.iterator()
        while (iterator.hasNext()) {
            var getList = ""
            var itb: Int
            val blockIt: String = iterator.next()
            val list: Iterator<Int> = Data.OreData[blockIt]!!.distrib.keys.iterator()

            while (list.hasNext()){
                itb = list.next()
                getList = getList + itb + "," + Data.OreData[blockIt]!!.distrib[itb] + ";"
            }

            Data.JERJsonOreData.put(blockIt, JsonDataHelper(Data.OreData[blockIt]!!.block, getList, Data.OreData[blockIt]!!.silktouch, Data.OreData[blockIt]!!.dropsList, Data.OreData[blockIt]!!.dim))
        }
    }

}
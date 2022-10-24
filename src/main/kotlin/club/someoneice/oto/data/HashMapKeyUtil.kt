package club.someoneice.oto.data

import java.util.*


object HashMapKeyUtil {
    fun getKey(map: HashMap<String, String>, value: String): String? {
        var key: String? = null
        for (getKey in map.keys) {
            if (map[getKey] == value) {
                key = getKey
            }
        }

        return key
    }
}
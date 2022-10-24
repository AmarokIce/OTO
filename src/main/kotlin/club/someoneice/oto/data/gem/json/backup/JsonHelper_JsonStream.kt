package club.someoneice.oto.data.gem.json.backup

import club.someoneice.oto.data.gem.Data
import com.google.gson.Gson
import com.google.gson.stream.JsonWriter
import java.io.File
import java.io.FileWriter

object JsonHelper_JsonStream {
    fun JsonHelper_JsonSteram() {
        val gson = Gson()
        // val jsonString = gson.toJson(Data.OreData)
        val path: String = System.getProperty("user.dir") + "\\oto_output"
        val file = File(path)
        // val file = Paths.get(System.getProperty("user.dir") + "\\oto_output\\output.json")
        val pathFile = FileWriter("$path\\output.json")
        if (!file.isDirectory && !file.exists()) {
            file.mkdir()
        }

        try {
            val data = Data.OreData
            val dataSet: Set<String> = data.keys
            val iterator: Iterator<String> = dataSet.iterator()
            // val writer: BufferedWriter = Files.newBufferedWriter(pathFile)
            // writer.write(jsonString)
            val writer: JsonWriter = JsonWriter(pathFile)

            while (iterator.hasNext()) {
                val blockIt = iterator.next()

                writer.beginObject()
                writer.name("ore_name").value(data[blockIt]!!.ore_name)
                writer.name("ore_distrib").value(data[blockIt]!!.ore_distrib.toString())
                writer.name("silktouch").value(data[blockIt]!!.silktouch)
                writer.name("drop_list").value(data[blockIt]!!.dropsList.toString())
                writer.name("dim").value(data[blockIt]!!.dim)
                writer.endObject()
            }
            pathFile.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
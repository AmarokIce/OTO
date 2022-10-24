package club.someoneice.oto.data.gem.json

import club.someoneice.oto.data.gem.Data
import com.google.gson.Gson
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object JsonHelper {
    fun JsonHelper() {
        val gson = Gson()
        // val jsonString = gson.toJson(Data.OreData)
        val path: String = System.getProperty("user.dir") + "\\oto_output"
        val file = File(path)
        val pathFile = Paths.get("$path\\output.json")

        // val pathFile = FileWriter("$path\\output.json")

        if (!file.isDirectory && !file.exists()) {
            file.mkdir()
        }

        try {
            val data = Data.OreData
            val dataSet: Set<String> = data.keys
            val iterator: Iterator<String> = dataSet.iterator()
            val writer: BufferedWriter = Files.newBufferedWriter(pathFile)
            // writer.write(jsonString)

            writer.write("[")

            while (iterator.hasNext()) {
                val blockIt = iterator.next()
                writer.write(gson.toJson(Data.OreData[blockIt]))
                if (iterator.hasNext()) {
                    writer.write(",")
                }
                writer.newLine()
            }
            writer.write("]")
            writer.close()  // must be close.

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
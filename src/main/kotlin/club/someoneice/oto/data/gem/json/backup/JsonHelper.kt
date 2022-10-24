package club.someoneice.oto.data.gem.json.backup

import club.someoneice.oto.data.gem.Data
import com.google.gson.Gson
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object JsonHelper {
    fun JsonHelper() {
        val gson = Gson()
        val jsonString = gson.toJson(Data.OreData)
        val path = File(System.getProperty("user.dir") + "\\oto_output")
        val pathFile = Paths.get(System.getProperty("user.dir") + "\\oto_output\\output.json")
        if (!path.isDirectory && !path.exists()) {
            path.mkdir()
        }

        try {
            val writer: BufferedWriter = Files.newBufferedWriter(pathFile)
            writer.write(jsonString)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
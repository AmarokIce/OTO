package club.someoneice.oto.data.gem.json.backup

import com.google.gson.Gson
import com.google.gson.stream.JsonWriter
import java.io.File
import java.io.FileWriter
import java.nio.file.Paths

object JsonSandman_JsonSteram {
    // Debug only. Don't use sandman.
    fun sandman() {
        val gson = Gson()
        // val jsonString = gson.toJson(Data.OreData)
        val path = File(System.getProperty("user.dir") + "\\oto_output")
        val pathFile = Paths.get(System.getProperty("user.dir") + "\\oto_output\\sandman.json")
        if (!path.isDirectory && !path.exists()) {
            path.mkdir()
        }

        // val writer: BufferedWriter = Files.newBufferedWriter(pathFile)
        // writer.write(jsonString)
        val writer = FileWriter(System.getProperty("user.dir") + "\\oto_output\\sandman.json")
        val jsonWriter = JsonWriter(writer)
        jsonWriter.beginObject()
        jsonWriter.name("1").value("1")
        jsonWriter.name("5").beginArray()
        jsonWriter.value("1")
        jsonWriter.value("2")
        jsonWriter.value("3").endArray()
        jsonWriter.endObject()
        writer.close()

    }
}
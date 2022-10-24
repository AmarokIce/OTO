package club.someoneice.oto.data.gem.json

import com.google.gson.Gson
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

object JsonSandman {
    // Debug only. Don't use sandman.
    // Just for test gson.
    var Data: HashMap<String, String> = HashMap<String, String>()
    var ataD: HashMap<String, String> = HashMap<String, String>()
    fun sandman() {
        val gson = Gson()
        Data.put("s", "r")
        Data.put("1", "r")
        Data.put("3", "r")

        ataD.put("r1", "s")
        ataD.put("r2", "1")
        ataD.put("r3", "3")

        val jsonString = gson.toJson(Data)
        val gnirtSnsoj = gson.toJson(ataD)
        val path = File(System.getProperty("user.dir") + "\\oto_output")
        val pathFile = Paths.get(System.getProperty("user.dir") + "\\oto_output\\sandman.json")
        if (!path.isDirectory && !path.exists()) {
            path.mkdir()
        }

        val writer: BufferedWriter = Files.newBufferedWriter(pathFile)
        writer.write("[")
        writer.write(jsonString)
        writer.newLine()
        writer.write(gnirtSnsoj)
        writer.write("]")
        // val writer = FileWriter(System.getProperty("user.dir") + "\\oto_output\\sandman.json")

        writer.close()

    }
}
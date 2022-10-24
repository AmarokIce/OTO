package club.someoneice.oto.config

import club.someoneice.oto.OTO
import net.minecraftforge.common.config.Configuration

class Config {
    init {
        val config: Configuration = OTO.config
        config.load()
        config.addCustomCategoryComment("OTO", "Welcome! Here is OTO config!")

        val ableUseRandomTP = config["Boolean", "Can Player Use RandomTP", RTP]
        ableUseRandomTP.comment = "If you wanna player can use /rtp, make this true. Or OP only."
        RTP = ableUseRandomTP.getBoolean(RTP)

        val getPosX = config["Int", "Enter PosX.", PosX]
        getPosX.comment = "If you wanna to changed random TP X range, changed this.I don't recommend setting more than 20000, too much tp will also consume the server's network "
        PosX = getPosX.getInt(PosX)

        val getPosZ = config["Int", "Enter PosZ.", PosZ]
        getPosZ.comment = "If you wanna to changed random TP Y range, changed this.I don't recommend setting more than 20000, too much tp will also consume the server's network "
        PosZ = getPosZ.getInt(PosZ)

        config.save()
    }

    companion object {
        var RTP: Boolean = true
        var PosX: Int = 5000
        var PosZ: Int = 5000
    }
}
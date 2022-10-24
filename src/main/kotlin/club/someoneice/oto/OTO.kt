package club.someoneice.oto

import club.someoneice.oto.command.*
import club.someoneice.oto.command.omo.*
import club.someoneice.oto.data.PlayerData
import club.someoneice.oto.data.gem.command.OreCommand
import club.someoneice.oto.data.gem.command.SandmanCommand
import cpw.mods.fml.common.FMLCommonHandler
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.common.config.Configuration


@Mod(modid = OTO.MODID, version = OTO.VERSION, dependencies = "required-after:legacymckotlin; after:omo")
class OTO {
    companion object {
        lateinit var config: Configuration
        const val MODID: String = "oto"
        const val VERSION: String = "1.0.1"
        var hasOMO: Boolean = false;
    }

    @Mod.Instance
    var instance: OTO? = null

    @EventHandler
    fun init(event: FMLInitializationEvent) {
        // Event
        MinecraftForge.EVENT_BUS.register(PlayerData())
        FMLCommonHandler.instance().bus().register(PlayerData())
    }

    @EventHandler
    fun perInit(event: FMLPreInitializationEvent) {
        config = Configuration(event.suggestedConfigurationFile)
    }

    @EventHandler
    fun serverStarting(event: FMLServerStartingEvent) {

        try {
            Class.forName("club.someoneice.omo.OTO")
            hasOMO = true
        } catch (_:ClassNotFoundException) { }

        event.registerServerCommand(Fill())
        event.registerServerCommand(Rfill())
        event.registerServerCommand(KillAllEntity())
        event.registerServerCommand(Opgive())
        event.registerServerCommand(OTP())
        event.registerServerCommand(OTOHelp())
        event.registerServerCommand(OreCommand())
        event.registerServerCommand(SandmanCommand())

        if (!hasOMO) {
            event.registerServerCommand(Rtp())
            event.registerServerCommand(SetPort())
            event.registerServerCommand(Backport())
            event.registerServerCommand(Back())
            event.registerServerCommand(Tpa())
            event.registerServerCommand(Tpaccept())
            event.registerServerCommand(Tpdeny())
        }
    }
}

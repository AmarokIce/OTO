package club.someoneice.oto.data.gem.command

import club.someoneice.oto.data.gem.OreGetter
import club.someoneice.oto.data.gem.json.JsonHelper
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.util.IChatComponent
import java.io.IOException

// Work for mcmod, output a world gen json.
class OreCommand: CommandBase() {
    override fun getCommandName(): String {
        return "orefile"
    }

    override fun getCommandUsage(p_71518_1_: ICommandSender): String {
        return "/orefile [chuck]"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>?) {
        val chuck: Int = if (list != null) {
            try { Integer.parseInt(list[0]) }
            catch (e :Exception) { throw Exception("Not Int.") }
        } else {
            25
        }

        val allBlock: Int = (2 * chuck * 16) * (2 * chuck * 16)

        sender.addChatMessage(ChatComponentTranslation("Now start get world gen!") as IChatComponent)

        for (posX in (0 - chuck * 16) .. (chuck * 16)) {
            for (posY in 0..255) {
                for (posZ in (0 - chuck * 16)..(chuck * 16)) {
                    OreGetter.OreGetter(
                        sender.entityWorld,
                        getPlayer(sender, sender.commandSenderName),
                        posX,
                        posY,
                        posZ,
                        allBlock
                    )
                }
            }
        }

        JsonHelper.JsonHelper()
        sender.addChatMessage(ChatComponentTranslation("Success!") as IChatComponent)

    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
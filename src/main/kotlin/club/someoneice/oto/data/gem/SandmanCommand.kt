package club.someoneice.oto.data.gem

import club.someoneice.oto.data.gem.json.JERsJsonHelper
import club.someoneice.oto.data.gem.json.JsonSandman
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.util.IChatComponent

// Debug only, don't use sandman command if you didn't know what you're doing. Even it will nothing happen.
class SandmanCommand: CommandBase() {
    override fun getCommandName(): String {
        return "sandman"
    }

    override fun getCommandUsage(p_71518_1_: ICommandSender): String {
        return "/sandman"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>?) {
        sender.addChatMessage(ChatComponentTranslation("Sandman Test Now Start!") as IChatComponent)
        val isJerMode: Boolean = list?.get(0) == "true"
        if (isJerMode) {
            sender.addChatMessage(ChatComponentTranslation("[Debug] JER flavor is start!") as IChatComponent)
            JERJsonMaker.JERJsonMaker()
            JERsJsonHelper.JsonHelper()
        }

        JsonSandman.sandman()
        sender.addChatMessage(ChatComponentTranslation("Success!") as IChatComponent)
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
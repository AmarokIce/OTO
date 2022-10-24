package club.someoneice.oto.data.gem.command

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

        JsonSandman.sandman()
        sender.addChatMessage(ChatComponentTranslation("Success!") as IChatComponent)
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
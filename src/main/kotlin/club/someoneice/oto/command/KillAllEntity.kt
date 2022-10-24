package club.someoneice.oto.command

import club.someoneice.oto.data.Util
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender

class KillAllEntity: CommandBase() {
    override fun getCommandName(): String {
        return "killallentity"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/rtp"
    }

    override fun processCommand(sender: ICommandSender, msg: Array<String>) {
        Util.findEntity(sender.entityWorld)?.clear()
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
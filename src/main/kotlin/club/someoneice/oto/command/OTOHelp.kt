package club.someoneice.oto.command

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.util.IChatComponent

class OTOHelp : CommandBase() {
    override fun getCommandName(): String {
        return "otohelp"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/otohelp"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>) {
        sender.addChatMessage(ChatComponentTranslation("====== OTO Command Help Tree ======")   as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.opgive.command")                    as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.killae.command")                    as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.fill.command")                      as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.rfill.command")                     as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.rtp.command")                       as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.setport.command")                   as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.backport.command")                  as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("oto.ototp.command")                     as IChatComponent)
        sender.addChatMessage(ChatComponentTranslation("=========== Page 1 / 1 ===========")    as IChatComponent)
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
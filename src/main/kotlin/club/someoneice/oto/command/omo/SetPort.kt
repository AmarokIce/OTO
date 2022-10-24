package club.someoneice.oto.command.omo

import club.someoneice.oto.data.PlayerData
import club.someoneice.oto.data.helper.PlayerPortDataHelper
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText
import net.minecraft.util.IChatComponent
import net.minecraft.world.WorldServer

class SetPort: CommandBase() {
    override fun getCommandName(): String {
        return "setport"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/setport"
    }

    override fun processCommand(sender: ICommandSender, msg: Array<String>) {
        val player: EntityPlayerMP = getPlayer(sender, sender.commandSenderName.toString()) as EntityPlayerMP
        PlayerData.PlayerPortList.put(sender.commandSenderName, PlayerPortDataHelper(player.worldObj as WorldServer, player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch))
        sender.addChatMessage(ChatComponentText("已经标记地点！") as IChatComponent)
    }

    override fun getRequiredPermissionLevel(): Int {
        return 0
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
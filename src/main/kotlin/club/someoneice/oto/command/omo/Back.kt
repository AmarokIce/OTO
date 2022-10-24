package club.someoneice.oto.command.omo

import club.someoneice.oto.data.PlayerData
import club.someoneice.oto.data.TeleportHelper
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText
import net.minecraft.util.IChatComponent
import net.minecraft.world.Teleporter
import net.minecraft.world.World
import net.minecraft.world.WorldServer

class Back: CommandBase() {
    override fun getCommandName(): String {
        return "back"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/back"
    }

    override fun processCommand(sender: ICommandSender, msg: Array<String>) {
        val player: EntityPlayerMP = getPlayer(sender, sender.commandSenderName.toString()) as EntityPlayerMP
        if (PlayerData.PlayerDataList.containsKey(sender.commandSenderName)) {
            val world: World? = PlayerData.PlayerDataList[sender.commandSenderName]?.world
            if ((player.worldObj as WorldServer) != (PlayerData.PlayerDataList[sender.commandSenderName]?.world as WorldServer))
                player.mcServer.configurationManager.transferPlayerToDimension(player, world?.provider?.dimensionId as Int, TeleportHelper(player.mcServer.worldServerForDimension(world.provider?.dimensionId as Int)) as Teleporter)
            player.playerNetServerHandler.setPlayerLocation(PlayerData.PlayerDataList[sender.commandSenderName]?.x as Double , PlayerData.PlayerDataList[sender.commandSenderName]?.y as Double, PlayerData.PlayerDataList[sender.commandSenderName]?.z as Double, PlayerData.PlayerDataList[sender.commandSenderName]?.RotX as Float, PlayerData.PlayerDataList[sender.commandSenderName]?.RotY as Float)
            sender.addChatMessage(ChatComponentText("已经回到上一次死亡地点！") as IChatComponent)
        } else {
            sender.addChatMessage(ChatComponentText("你从未死亡！") as IChatComponent)
        }

    }

    override fun getRequiredPermissionLevel(): Int {
        return 0
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
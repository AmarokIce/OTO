package club.someoneice.oto.command

import club.someoneice.oto.data.HashMapKeyUtil
import club.someoneice.oto.data.PlayerData
import club.someoneice.oto.data.TeleportHelper
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText
import net.minecraft.util.IChatComponent
import net.minecraft.world.Teleporter

class Tpaccept : CommandBase() {
    override fun getCommandName(): String {
        return "tpaccept"
    }

    override fun getCommandUsage(p_71518_1_: ICommandSender): String {
        return "/tpaccept"
    }

    override fun processCommand(sender: ICommandSender, msg: Array<String>) {
        val playerName:String? = HashMapKeyUtil.getKey(PlayerData.PlayerTPList, sender.commandSenderName)

        if (playerName != null) {
            val player: EntityPlayerMP = sender as EntityPlayerMP
            val playerAsk: EntityPlayerMP = getPlayer(sender, playerName)
            if (player.worldObj == playerAsk.worldObj) {
                if (!PlayerData.PlayerGoing[playerName]!!)
                    playerAsk.playerNetServerHandler.setPlayerLocation(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch)
                else player.playerNetServerHandler.setPlayerLocation(playerAsk.posX, playerAsk.posY, playerAsk.posZ, playerAsk.rotationYaw, playerAsk.rotationPitch)
            } else {
                if (!PlayerData.PlayerGoing[playerName]!!) {
                    playerAsk.mcServer.configurationManager.transferPlayerToDimension(playerAsk, player.worldObj?.provider?.dimensionId as Int, TeleportHelper(playerAsk.mcServer.worldServerForDimension(player.worldObj.provider?.dimensionId as Int)) as Teleporter)
                    playerAsk.playerNetServerHandler.setPlayerLocation(player.posX, player.posY, player.posZ, player.rotationYaw, player.rotationPitch)
                } else {
                    player.mcServer.configurationManager.transferPlayerToDimension(player, playerAsk.worldObj?.provider?.dimensionId as Int, TeleportHelper(player.mcServer.worldServerForDimension(playerAsk.worldObj.provider?.dimensionId as Int)) as Teleporter)
                    player.playerNetServerHandler.setPlayerLocation(playerAsk.posX, playerAsk.posY, playerAsk.posZ, playerAsk.rotationYaw, playerAsk.rotationPitch)
                }
                // player.addChatMessage(ChatComponentText("You are not in same world???") as IChatComponent)
                // playerAsk.addChatMessage(ChatComponentText("You are not in same world???") as IChatComponent)
            }



            PlayerData.PlayerTPList.remove(playerName.toString())
        } else sender.addChatMessage(ChatComponentText("??????????????????????????????") as IChatComponent)
    }

    override fun getRequiredPermissionLevel(): Int {
        return 0
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
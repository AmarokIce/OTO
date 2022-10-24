package club.someoneice.oto.command

import club.someoneice.oto.data.TeleportHelper
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.world.Teleporter

class OTP: CommandBase() {
    override fun getCommandName(): String {
        return "ototp"
    }

    override fun getCommandUsage(p_71518_1_: ICommandSender): String {
        return "/ototp [player] [player]"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>) {
        var APlayer: EntityPlayerMP? = getPlayer(sender, sender.commandSenderName)
        var BPlayer: EntityPlayerMP? = getPlayer(sender, list[0])

        if (list.size == 2) {
            APlayer = getPlayer(sender, list[0])
            BPlayer = getPlayer(sender, list[1])
        }

        if (APlayer == null || BPlayer == null) {
            sender.addChatMessage(ChatComponentTranslation("oto.notfindplayer.command"))
            return
        }

        val worldID: Int = BPlayer.worldObj.provider.dimensionId
        if (APlayer.worldObj != BPlayer.worldObj)
            APlayer.mcServer.configurationManager.transferPlayerToDimension(APlayer, worldID, TeleportHelper(APlayer.mcServer.worldServerForDimension(worldID)) as Teleporter)

        APlayer.playerNetServerHandler.setPlayerLocation(BPlayer.posX, BPlayer.posY, BPlayer.posZ, BPlayer.rotationYaw, BPlayer.rotationPitch)
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
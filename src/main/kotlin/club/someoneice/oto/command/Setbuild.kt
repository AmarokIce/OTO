package club.someoneice.oto.command

import club.someoneice.oto.data.PlayerData
import club.someoneice.oto.data.helper.BuildHelper
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.util.IChatComponent
import net.minecraft.world.World

class Setbuild: CommandBase() {
    override fun getCommandName(): String {
        return "setbuild"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/setbuild [name]"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>?) {
        val player: EntityPlayerMP = getPlayer(sender, sender.commandSenderName) as EntityPlayerMP
        val world: World = player.worldObj

        val name: String = list?.get(0) ?: return
        if (PlayerData.PlayerBuildList.containsKey(name)) {
            val data: BuildHelper = PlayerData.PlayerBuildList[name]!!
            val sx: Int = player.posX.toInt() + 1
            val sy: Int = player.posY.toInt()
            val sz: Int = player.posZ.toInt() + 1
            val ex: Int = sx + data.LongX
            val ey: Int = sy + data.LongY
            val ez: Int = sz + data.LongZ
            var i = 0

            for (posX: Int in sx .. ex) {
                for (posY: Int in sy..ey) {
                    for (posZ: Int in sz..ez) {
                        if (i >= data.build.size) break
                        world.setBlock(posX, posY, posZ, data.build[i], data.meta[i], 3)
                        i += 1
                    }
                }
            }
        } else {
            sender.addChatMessage(ChatComponentTranslation("oto.cannot_find_build.command") as IChatComponent)
        }
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
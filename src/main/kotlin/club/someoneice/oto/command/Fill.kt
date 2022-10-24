package club.someoneice.oto.command

import net.minecraft.block.Block
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText

class Fill : CommandBase() {
    override fun getCommandName(): String {
        return "fill"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/fill [start x] [start y] [start z] [end x] [end y] [end z] [Block RegisterName or Block Id] [meta]"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>?) {
        if (list?.size!! < 6) {
            sender.addChatMessage(ChatComponentText("Worry! Please try ' /fill [start x] [start y] [start z] [end x] [end y] [end z] [Block RegisterName or Block Id] [meta] ' "))
            return
        }

        val player: EntityPlayerMP = getPlayer(sender, sender.commandSenderName.toString()) as EntityPlayerMP

        if (list[0] == "~")
            list[0] = player.posX.toInt().toString()

        if (list[1] == "~")
            list[1] = player.posY.toInt().toString()

        if (list[2] == "~")
            list[2] = player.posZ.toInt().toString()

        if (list[3] == "~")
            list[3] = player.posX.toInt().toString()

        if (list[4] == "~")
            list[4] = player.posY.toInt().toString()

        if (list[5] == "~")
            list[5] = player.posZ.toInt().toString()

        var sx: Int = Integer.parseInt(list[0])
        var sy: Int = Integer.parseInt(list[1])
        var sz: Int = Integer.parseInt(list[2])

        var ex: Int = Integer.parseInt(list[3])
        var ey: Int = Integer.parseInt(list[4])
        var ez: Int = Integer.parseInt(list[5])

        val block: Block = getBlockByText(sender, list[6])
        val meta: Int = Integer.parseInt(list?.get(7) ?: "0")
        var i: Int  // A sandman.

        if (sx > ex) {
            i = sx
            sx = ex
            ex = i
        }

        if (sy > ey) {
            i = sy
            sy = ey
            ey = i
        }

        if (sz > ez) {
            i = sz
            sz = ez
            ez = i
        }

        for (posX: Int in sx..ex)
            for (posY: Int in sy..ey)
                for (posZ: Int in sz..ez)
                    player.worldObj.setBlock(posX, posY, posZ, block, meta, 3)
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
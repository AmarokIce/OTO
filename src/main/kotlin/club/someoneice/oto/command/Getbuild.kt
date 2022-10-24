package club.someoneice.oto.command

import club.someoneice.oto.data.PlayerData
import club.someoneice.oto.data.helper.BuildHelper
import net.minecraft.block.Block
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText
import net.minecraft.world.World
import java.util.ArrayList

class Getbuild: CommandBase() {
    override fun getCommandName(): String {
        return "getbuild"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/getbuild [name] [x] [y] [z] [x] [y] [z]"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>) {
        val player: EntityPlayerMP = getPlayer(sender, sender.commandSenderName) as EntityPlayerMP
        val world: World = player.worldObj
        if (list.size < 7) return

        val name: String = list[0]

        if (list[1] == "~")
            list[1] = player.posX.toInt().toString()

        if (list[2] == "~")
            list[2] = player.posY.toInt().toString()

        if (list[3] == "~")
            list[3] = player.posZ.toInt().toString()

        if (list[4] == "~")
            list[4] = player.posX.toInt().toString()

        if (list[5] == "~")
            list[5] = player.posY.toInt().toString()

        if (list[6] == "~")
            list[6] = player.posZ.toInt().toString()

        var sx: Int = Integer.parseInt(list[1])
        var sy: Int = Integer.parseInt(list[2])
        var sz: Int = Integer.parseInt(list[3])

        var ex: Int = Integer.parseInt(list[4])
        var ey: Int = Integer.parseInt(list[5])
        var ez: Int = Integer.parseInt(list[6])

        var i: Int
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

        val buildSide: Int = (ex - sx) * (ez - sz) * (ey - sy)
        val blockList: ArrayList<Block> = ArrayList<Block>()
        val blockMeta: ArrayList<Int> = ArrayList<Int>()

        i = 0
        for (posX: Int in sx .. ex)
            for (posY: Int in sy .. ey)
                for (posZ: Int in sz..ez) {
                    blockList[i] = world.getBlock(posX, posY, posZ)
                    blockMeta[i] = world.getBlockMetadata(posX, posY, posZ)
                    i += 1
                }

        PlayerData.PlayerBuildList.put(name, BuildHelper(blockList, blockMeta, ex - sx, ey - sy, ez - sz))

        sender.addChatMessage(ChatComponentText("Success! $name is save with $buildSide Blocks!"))
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
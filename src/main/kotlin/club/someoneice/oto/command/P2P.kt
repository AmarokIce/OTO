package club.someoneice.oto.command

import net.minecraft.block.Block
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.init.Blocks
import net.minecraft.world.World

class P2P: CommandBase() {
    override fun getCommandName(): String {
        return "p2p"
    }

    override fun getCommandUsage(p_71518_1_: ICommandSender): String {
        return "/p2p [x] [y] [z] [x] [y] [z]"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>) {
        val world: World = sender.entityWorld

        if (list.size < 6) return

        val sx: Int = Integer.parseInt(list[0])
        val sy: Int = Integer.parseInt(list[1])
        val sz: Int = Integer.parseInt(list[2])

        val ex: Int = Integer.parseInt(list[3])
        val ey: Int = Integer.parseInt(list[4])
        val ez: Int = Integer.parseInt(list[5])

        val block: Block = world.getBlock(sx, sy, sz)
        val meta: Int = world.getBlockMetadata(sx, sy, sz)
        world.setBlock(sx, sy, sz, Blocks.air)
        world.setBlock(ex, ey, ez, block, meta, 3)
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
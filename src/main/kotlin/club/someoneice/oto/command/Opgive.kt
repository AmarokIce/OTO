package club.someoneice.oto.command

import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.item.ItemStack
import net.minecraft.server.MinecraftServer
import net.minecraft.util.ChatComponentTranslation
import net.minecraft.util.IChatComponent

class Opgive : CommandBase() {
    override fun getCommandName(): String {
        return "otogive"
    }

    override fun getCommandUsage(sender: ICommandSender): String {
        return "/otogive"
    }

    override fun processCommand(sender: ICommandSender, list: Array<String>) {
        val playerList = MinecraftServer.getServer().allUsernames
        for (i in playerList) {
            val player: EntityPlayerMP = getPlayer(sender, i)
            if (list[0] != "hand")
                player.inventory.addItemStackToInventory(ItemStack(getItemByText(sender, list[0])))
            else if (getPlayer(sender, sender.commandSenderName).heldItem != null)
                player.inventory.addItemStackToInventory(getPlayer(sender, sender.commandSenderName).heldItem)
            else {
                sender.addChatMessage(ChatComponentTranslation("oto.notfinditem.command") as IChatComponent)
                return
            }
        }
    }

    override fun getRequiredPermissionLevel(): Int {
        return 4
    }
}
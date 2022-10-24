package club.someoneice.oto.event

import club.someoneice.oto.data.PlayerData.Companion.PlayerDataList
import club.someoneice.oto.data.PlayerDeathData
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraft.world.WorldServer
import net.minecraftforge.event.entity.player.PlayerDropsEvent

class PlayerListener {
    @SubscribeEvent(priority= EventPriority.LOWEST)
    fun onPlayerDie(event: PlayerDropsEvent) {
        val player: String = event.entityPlayer.displayName
        val playerData = PlayerDeathData(event.entityPlayer.worldObj as WorldServer, event.entityPlayer?.posX as Double, event.entityPlayer.posY, event.entityPlayer.posZ, event.entityPlayer.rotationYaw, event.entityPlayer.rotationPitch)
        PlayerDataList.put(player , playerData)
    }
}
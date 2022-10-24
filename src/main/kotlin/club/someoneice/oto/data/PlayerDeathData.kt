package club.someoneice.oto.data

import net.minecraft.world.WorldServer

data class PlayerDeathData(
    val world: WorldServer,
    val x: Double,
    val y: Double,
    val z: Double,
    val RotX: Float,
    val RotY: Float
)

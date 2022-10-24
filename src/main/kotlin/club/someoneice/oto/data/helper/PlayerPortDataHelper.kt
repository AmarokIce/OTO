package club.someoneice.oto.data.helper

import net.minecraft.world.WorldServer

data class PlayerPortDataHelper(
    val world: WorldServer,
    val x: Double,
    val y: Double,
    val z: Double,
    val RotX: Float,
    val RotY: Float
)

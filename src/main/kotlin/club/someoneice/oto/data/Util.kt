package club.someoneice.oto.data

import net.minecraft.world.World


object Util {
    fun findEntity(world: World): MutableList<Any?>? {
        return world.getLoadedEntityList()
    }
}
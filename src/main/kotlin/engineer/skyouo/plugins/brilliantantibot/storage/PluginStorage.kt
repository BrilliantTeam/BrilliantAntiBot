package engineer.skyouo.plugins.brilliantantibot.storage

import net.md_5.bungee.api.connection.ProxiedPlayer
import java.util.*

object PluginStorage {
    private val players = mutableMapOf<String, PlayerData>()

    fun getPlayer(player: ProxiedPlayer): PlayerData? {
        return players[player.uniqueId.toString()]
    }

    fun setPlayer(player: ProxiedPlayer, lastDisconnectAt: Date) {
        val uuid = player.uniqueId.toString()

        val existing = getPlayer(player)
        if (existing != null) {
            players[uuid] = existing.copy(lastJoinAt = lastDisconnectAt)
        } else {
            players[uuid] = PlayerData(uuid, lastDisconnectAt)
        }
    }
}
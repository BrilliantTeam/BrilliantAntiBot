package engineer.skyouo.plugins.brilliantantibot.event

import engineer.skyouo.plugins.brilliantantibot.storage.PluginConfig
import engineer.skyouo.plugins.brilliantantibot.storage.PluginStorage
import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.event.PlayerDisconnectEvent
import net.md_5.bungee.api.event.PostLoginEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler
import java.util.*

class BungeeEventListener : Listener {
    @EventHandler
    fun onPostLogin(event: PostLoginEvent) {
        val player = event.player
        val data = PluginStorage.getPlayer(player)

        if (data != null && data.isRateLimited()) {
            val reason = TextComponent(
                ChatColor.translateAlternateColorCodes(
                    '&',
                    "&c你重新進出伺服器的速度太快了\n&c請等候 &a${PluginConfig.rateLimit} &c秒後再進入伺服器，倘若造成您的不便敬請見諒。"
                )
            )

            player.disconnect(reason)
        }
    }

    @EventHandler
    fun onPlayerDisconnect(event: PlayerDisconnectEvent) {
        PluginStorage.setPlayer(event.player, Date())
    }
}
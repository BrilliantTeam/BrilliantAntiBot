package engineer.skyouo.plugins.brilliantantibot

import engineer.skyouo.plugins.brilliantantibot.event.BungeeEventListener
import engineer.skyouo.plugins.brilliantantibot.storage.PluginConfig
import net.md_5.bungee.api.plugin.Plugin
import java.util.logging.Logger

@Suppress("unused")
class BrilliantAntiBot : Plugin() {
    companion object {
        val LOGGER: Logger = Logger.getLogger("BrilliantAntiBot")
        lateinit var INSTANCE: Plugin
    }

    override fun onEnable() {
        INSTANCE = this
        PluginConfig.init()
        proxy.pluginManager.registerListener(this, BungeeEventListener())

        LOGGER.info("BrilliantAntiBot is enabled")
    }

    override fun onDisable() {
        PluginConfig.save()

        LOGGER.info("BrilliantAntiBot is disabled")
    }
}
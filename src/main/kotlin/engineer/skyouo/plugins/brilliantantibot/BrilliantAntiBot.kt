package engineer.skyouo.plugins.brilliantantibot

import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

@Suppress("unused")
class BrilliantAntiBot : JavaPlugin() {
    companion object {
        val LOGGER: Logger = Logger.getLogger("ExamplePlugin")
    }

    override fun onEnable() {
        LOGGER.info("ExamplePlugin is enabled")
    }

    override fun onDisable() {
        LOGGER.info("ExamplePlugin is disabled")
    }
}
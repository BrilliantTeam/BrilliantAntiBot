package engineer.skyouo.plugins.brilliantantibot.storage

import engineer.skyouo.plugins.brilliantantibot.util.Util
import net.md_5.bungee.config.Configuration
import net.md_5.bungee.config.ConfigurationProvider
import net.md_5.bungee.config.YamlConfiguration
import java.io.File

object PluginConfig {
    private lateinit var file: File
    private lateinit var configuration: Configuration
    private lateinit var provider: ConfigurationProvider

    /**
     * The time limit for the same player to connect repeatedly.
     * Example: set the value to 10, i.e. the player can't connect to the server repeatedly within 10 seconds
     */
    val rateLimit: Int
        get() = configuration.getInt("rate_limit", 10)


    fun init() {
        file = Util.getFileLocation("config.yml")
        if (!file.exists()) {
            file.createNewFile()
        }

        provider = ConfigurationProvider.getProvider(YamlConfiguration::class.java)
        configuration = provider.load(file)

        if (!configuration.contains("rate_limit")) {
            configuration.set("rate_limit", 10)
        }

        save()
    }

    fun save() {
        provider.save(configuration, file)
    }
}
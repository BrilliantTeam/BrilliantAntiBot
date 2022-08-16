package engineer.skyouo.plugins.brilliantantibot.storage

import java.util.Date

data class PlayerData(val uuid: String, val lastJoinAt: Date) {
    fun isRateLimited(): Boolean {
        val rateLimit = PluginConfig.rateLimit
        val now = Date()
        val diff = now.time - lastJoinAt.time

        return diff < rateLimit * 1000
    }
}

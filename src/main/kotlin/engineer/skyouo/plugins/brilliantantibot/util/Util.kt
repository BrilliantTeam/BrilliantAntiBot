package engineer.skyouo.plugins.brilliantantibot.util

import java.io.File

object Util {
    private fun getBaseDirectory(): File {
        return File("plugins/BrilliantAntiBot")
    }

    fun getFileLocation(fileName: String): File {
        val baseDirectory: File = getBaseDirectory()
        if (!baseDirectory.exists()) {
            baseDirectory.mkdirs()
        }

        return baseDirectory.resolve(fileName)
    }
}
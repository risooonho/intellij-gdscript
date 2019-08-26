package plugin.completion.deserialization.utilities

import java.awt.Color

object ColorParser {

    fun parse(code: String): Color {
        val channels = readChannels(code)
        return Color(channels[0], channels[1], channels[2], channels[3])
    }

    private fun readChannels(constructorInvocationCode: String) = constructorInvocationCode
        .replace("Color", "")
        .removeSurrounding("(", ")")
        .split(",")
        .map { it.trim() }
        .map { it.toFloat() }

}
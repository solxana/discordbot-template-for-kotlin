package com.it_finne.discordbot_template_for_kotlin.config

import com.charleskorn.kaml.Yaml
import com.it_finne.discordbot_template_for_kotlin.application.constant.ApplicationMode
import com.it_finne.discordbot_template_for_kotlin.config.property.Database
import com.it_finne.discordbot_template_for_kotlin.config.property.DiscordBot
import kotlinx.serialization.Serializable

@Serializable
data class Configuration(
    val discordbot: DiscordBot,
    val database: Database
) {
    companion object {
        fun load(applicationMode: ApplicationMode): Configuration {
            val filename = "/application-${applicationMode.value}.yaml"
            return Yaml.default.decodeFromString(
                serializer(),
                Configuration::class.java.getResource(filename).readText()
            )
        }
    }
}
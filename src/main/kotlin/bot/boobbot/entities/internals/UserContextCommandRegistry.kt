package bot.boobbot.entities.internals

import bot.boobbot.BoobBot
import bot.boobbot.entities.framework.ExecutableUserContextCommand
import bot.boobbot.entities.framework.Indexer
import bot.boobbot.entities.framework.SlashIndexer
import bot.boobbot.entities.framework.UserContextIndexer

class UserContextCommandRegistry : HashMap<String, ExecutableUserContextCommand>() {
    init {
        val indexer = UserContextIndexer("bot.boobbot.contextcommands")
        val commands = indexer.getCommands().associateBy { it.name }
        this.putAll(commands)
        BoobBot.log.info("Successfully loaded ${commands.size} context commands!")
    }

    fun findCommand(commandName: String): ExecutableUserContextCommand? {
        return this[commandName]
            ?: values.firstOrNull { it.properties.aliases.contains(commandName) }
    }
}

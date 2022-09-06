package bot.boobbot.slashcommands.interactions

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.FunCommand
import bot.boobbot.entities.framework.FunSlashCommand

@CommandProperties(description = "Insult someone.", category = Category.INTERACTIONS, aliases = ["ins"])
class Insult : FunSlashCommand("insult")

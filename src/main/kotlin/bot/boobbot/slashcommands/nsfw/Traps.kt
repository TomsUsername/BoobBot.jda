package bot.boobbot.slashcommands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.BbApiSlashCommand

@CommandProperties(description = "Traps are hot!", nsfw = true, category = Category.KINKS)
class Traps : BbApiSlashCommand("traps")

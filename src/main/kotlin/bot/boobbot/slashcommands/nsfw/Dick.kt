package bot.boobbot.slashcommands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.BbApiSlashCommand

@CommandProperties(description = "Got dick?", nsfw = true, category = Category.GENERAL)
class Dick : BbApiSlashCommand("penis")

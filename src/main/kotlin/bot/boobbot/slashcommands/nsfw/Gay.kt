package bot.boobbot.slashcommands.nsfw

import bot.boobbot.entities.framework.BbApiSlashCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties

@CommandProperties(description = "Got men?", nsfw = true, category = Category.KINKS)
class Gay : BbApiSlashCommand("gay")

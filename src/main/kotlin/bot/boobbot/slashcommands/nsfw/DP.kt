package bot.boobbot.slashcommands.nsfw

import bot.boobbot.entities.framework.BbApiSlashCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties

@CommandProperties(description = "Gotta get that double love!", nsfw = true, category = Category.GENERAL)
class DP : BbApiSlashCommand("dpgirls")

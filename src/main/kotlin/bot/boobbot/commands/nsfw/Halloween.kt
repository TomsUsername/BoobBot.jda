package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.BbApiCommand

@CommandProperties(description = "Halloween \uD83D\uDC7B", nsfw = true, category = Category.HOLIDAY)
class Halloween : BbApiCommand("halloween")

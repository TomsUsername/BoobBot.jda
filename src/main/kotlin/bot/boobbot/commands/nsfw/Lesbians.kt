package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.BbApiCommand

@CommandProperties(description = "Lesbians are sexy!", nsfw = true, category = Category.KINKS)
class Lesbians : BbApiCommand("lesbians")

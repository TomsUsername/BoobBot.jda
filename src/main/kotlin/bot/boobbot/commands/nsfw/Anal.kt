package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.impl.BbApiCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties

@CommandProperties(description = "That ass love tho.", nsfw = true, category = Category.KINKS)
class Anal : BbApiCommand("anal")

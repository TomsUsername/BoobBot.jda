package bot.boobbot.commands.interactions

import bot.boobbot.entities.framework.BbApiInteractionCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties

@CommandProperties(description = "finger someone.", category = Category.INTERACTIONS, nsfw = true)
class Finger : BbApiInteractionCommand("finger", "<a:lemmeegirlu:761359677778821130> %s fingers %s, and they like it!")
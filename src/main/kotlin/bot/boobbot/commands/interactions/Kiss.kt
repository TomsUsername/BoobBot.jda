package bot.boobbot.commands.interactions

import bot.boobbot.entities.framework.*

@CommandProperties(description = "kiss someone.", category = Category.INTERACTIONS, nsfw = true)
class Kiss : BbApiInteractionCommand("kiss", "<a:kiss:866447434762027038> %s kisses %s")

package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.BbApiCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties

@CommandProperties(
    description = "Redheads: because redder is better!",
    aliases = ["redhead", "redheads"],
    nsfw = true,
    category = Category.GENERAL,
    donorOnly = true
)
class Red : BbApiCommand("red")

package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.BbApiCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties

@CommandProperties(
    description = "tentacles.",
    nsfw = true,
    category = Category.KINKS,
    aliases = ["aly"]
)
class Tentacle : BbApiCommand("tentacle")

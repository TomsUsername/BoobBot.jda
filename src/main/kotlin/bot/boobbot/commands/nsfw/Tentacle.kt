package bot.boobbot.commands.nsfw

import bot.boobbot.flight.Category
import bot.boobbot.flight.CommandProperties
import bot.boobbot.models.BbApiCommand

@CommandProperties(description = "tentacles.", nsfw = true, category = Category.KINKS, aliases = ["Aly"])
class Tentacle : BbApiCommand("tentacle")

package bot.boobbot.commands.`fun`

import bot.boobbot.flight.Category
import bot.boobbot.flight.CommandProperties
import bot.boobbot.models.MemeAvatarCommand

@CommandProperties(description = "Trash.", nsfw = false, category = Category.FUN, guildOnly = true)
class Trash : MemeAvatarCommand("trash")
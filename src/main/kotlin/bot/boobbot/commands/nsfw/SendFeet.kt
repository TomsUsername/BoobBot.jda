package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.SendCommand

@CommandProperties(
    description = "Sends feet to you or another user",
    guildOnly = true,
    aliases = ["senddyna"],
    category = Category.SEND
)
class SendFeet : SendCommand("feet", "feet")

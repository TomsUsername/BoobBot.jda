package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties
import bot.boobbot.entities.framework.annotations.Option
import bot.boobbot.entities.framework.impl.SendCommand
import net.dv8tion.jda.api.interactions.commands.OptionType

@CommandProperties(
    description = "Sends feet to you or another user",
    guildOnly = true,
    aliases = ["senddyna"],
    category = Category.SEND,
    nsfw = true
)
@Option(name = "to", description = "The user to send to.", type = OptionType.USER, required = false)
class SendFeet : SendCommand("feet", "feet")

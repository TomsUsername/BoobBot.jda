package bot.boobbot.commands.interactions

import bot.boobbot.entities.framework.impl.BbApiInteractionCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties
import bot.boobbot.entities.framework.annotations.Option
import net.dv8tion.jda.api.interactions.commands.OptionType

@CommandProperties(description = "lick someone.", category = Category.INTERACTIONS, nsfw = true)
@Option(name = "with", description = "The user to interact with.", type = OptionType.USER)
class Lick : BbApiInteractionCommand("lick", "<a:play:866441014830563388> %s licks %s")

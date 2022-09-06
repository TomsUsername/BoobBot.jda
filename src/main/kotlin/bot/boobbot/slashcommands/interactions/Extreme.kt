package bot.boobbot.slashcommands.interactions

import bot.boobbot.entities.framework.BbApiInteractionSlashCommand
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties

@CommandProperties(description = "Are you extreme?", category = Category.INTERACTIONS, nsfw = true)
class Extreme : BbApiInteractionSlashCommand("extreme", "<:extreme:866451714471231510> %s likes it extreme. Are you in %s?")

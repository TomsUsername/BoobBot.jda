package bot.boobbot.slashcommands.interactions

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties
import bot.boobbot.entities.framework.FunSlashCommand

@CommandProperties(description = "Pickup someone.", category = Category.INTERACTIONS, aliases = ["pu"])
class Pickup : FunSlashCommand("pickups")

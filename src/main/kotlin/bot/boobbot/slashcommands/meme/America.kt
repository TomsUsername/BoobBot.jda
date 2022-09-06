package bot.boobbot.slashcommands.meme

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties
import bot.boobbot.entities.framework.MemeAvatarSlashCommand

@CommandProperties(description = "America.", category = Category.MEME, guildOnly = true)
class America : MemeAvatarSlashCommand("america")
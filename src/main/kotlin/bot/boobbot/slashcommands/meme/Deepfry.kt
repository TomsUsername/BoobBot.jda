package bot.boobbot.slashcommands.meme

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.annotations.CommandProperties
import bot.boobbot.entities.framework.MemeAvatarSlashCommand

@CommandProperties(description = "Deepfry.", category = Category.MEME, guildOnly = true)
class Deepfry : MemeAvatarSlashCommand("deepfry")
package bot.boobbot.commands.nsfw

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.NekoLifeApiCommand

@CommandProperties(
    description = "Lewd Neko gifs! <:p_:475801484282429450>",
    nsfw = true,
    category = Category.FANTASY,
    donorOnly = true,
    aliases = ["ng"]
)
class Nekogif : NekoLifeApiCommand("nsfw_neko_gif")

package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.entities.framework.Command
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.Context
import bot.boobbot.entities.framework.SubCommand

@CommandProperties(
    description = "Change whether you can receive dicks in your DMs",
    donorOnly = true,
    aliases = ["cb"]
)
class CockBlock : Command {

    override fun execute(ctx: Context) {
        ctx.send("`bbcockblock <${subcommands.keys.joinToString("|")}>`")
    }

    @SubCommand(aliases = ["On"])
    fun on(ctx: Context) {
        BoobBot.database.setUserCockBlocked(ctx.author.id, true)
        ctx.send("You're no longer able to receive dicks via DMs \uD83C\uDF46") // eggplant
    }

    @SubCommand(aliases = ["Off"])
    fun off(ctx: Context) {
        BoobBot.database.setUserCockBlocked(ctx.author.id, false)
        ctx.send("You're now able to receive dicks via DMs <:moans:583453348984913933>")
    }

}

package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.entities.framework.interfaces.Command
import bot.boobbot.entities.framework.annotations.CommandProperties
import bot.boobbot.entities.framework.MessageContext
import bot.boobbot.entities.framework.annotations.SubCommand
import bot.boobbot.utils.Formats
import bot.boobbot.utils.Utils
import net.dv8tion.jda.api.Permission

@CommandProperties(aliases = ["cc"], description = "Custom commands", guildOnly = true)
class Custom : Command {

    override fun execute(ctx: MessageContext) {
        ctx.reply("`bbcc <${subcommands.keys.joinToString("|")}>`")
    }

    @SubCommand
    fun add(ctx: MessageContext) {
        if (!ctx.userCan(Permission.MANAGE_SERVER)) {
            return ctx.reply("You don't have `MANAGE_SERVER` permission, whore.")
        }

        if (!Utils.checkDonor(ctx.message)) {
            return ctx.reply(
                Formats.error(
                    " Sorry this command is only available to our Patrons.\n<:p_:475801484282429450> "
                            + "Stop being a cheap fuck and join today!\nhttps://www.patreon.com/OfficialBoobBot"
                )
            )
        }

        if (ctx.args.isEmpty() || ctx.args.size < 2) {
            return ctx.reply("You need to specify tag name and content, whore.")
        }

        val tagName = ctx.args[0]
        val tagContent = ctx.args.drop(1).joinToString(" ")

        BoobBot.database.addCustomCommand(ctx.guild!!.id, tagName, tagContent)
        ctx.reply("done whore")
    }

    @SubCommand(aliases = ["del", "remove", "rem"])
    fun delete(ctx: MessageContext) {
        if (!ctx.userCan(Permission.MANAGE_SERVER)) {
            return ctx.reply("You don't have `MANAGE_SERVER` permission, whore.")
        }

        val tagName = ctx.args.firstOrNull()
            ?: return ctx.reply("what tag do you want to delete, whore")

        if (BoobBot.database.findCustomCommand(ctx.guild!!.id, tagName) == null) {
            return ctx.reply("wtf, why are you trying to remove a non-existent command?")
        }

        BoobBot.database.removeCustomCommand(ctx.guild.id, tagName)
        ctx.reply("done whore")
    }

    @SubCommand
    fun list(ctx: MessageContext) {
        val allCommands = BoobBot.database.getCustomCommands(ctx.guild!!.id)

        if (allCommands.isEmpty()) {
            return ctx.reply("This server has no custom commands.")
        }

        ctx.reply("```\n${allCommands.keys.joinToString(", ")}```")
    }

}
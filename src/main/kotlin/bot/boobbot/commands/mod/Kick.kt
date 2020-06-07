package bot.boobbot.commands.mod

import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.Context
import bot.boobbot.entities.framework.ModCommand
import net.dv8tion.jda.api.Permission

@CommandProperties(
    description = "Boot an asshat from the server. <:p_:475801484282429450>",
    donorOnly = true,
    guildOnly = true,
    category = Category.MOD,
    userPermissions = [Permission.KICK_MEMBERS],
    botPermissions = [Permission.KICK_MEMBERS]
)
class Kick : ModCommand() {

    override fun execute(ctx: Context) {
        val (target, reason) = resolveTargetAndReason(ctx)
        val auditReason = reason ?: "No reason was given"

        if (target == null) {
            return ctx.send("How in the fuck would i know who you want to kick if you don't give me a valid target?")
        }

        if (target.idLong == ctx.author.idLong) {
            return ctx.send("You must be special if you're really trying to kick yourself.")
        }

        if (!ctx.member!!.canInteract(target)) {
            return ctx.send("You dont have permission to do that, fuck off")
        }

        if (target.idLong == ctx.selfMember!!.idLong) {
            return ctx.send("Don't you fucking touch me whore, I will end you.")
        }

        if (!ctx.selfMember.canInteract(target)) {
            return ctx.send("I dont have permission to do that, Fix it or fuck off")
        }

        target.kick("Kicked by: ${ctx.author.name} [${ctx.author.idLong}] for: $auditReason")
            .queue(
                { ctx.send("done, good riddance stupid bitch") },
                { ctx.send("what the fuck i couldn't kick?") }
            )
    }
}

package bot.boobbot.commands.bot

import bot.boobbot.BoobBot
import bot.boobbot.entities.framework.Command
import bot.boobbot.entities.framework.CommandProperties
import bot.boobbot.entities.framework.Context
import bot.boobbot.entities.framework.SubCommand
import bot.boobbot.utils.Colors

@CommandProperties(description = "Receive your rewards after subscribing on Patreon.")
class Perks : Command {
    companion object {
        private const val PREMIUM_SERVERS = 3
    }

    override fun execute(ctx: Context) {
        ctx.send {
            setColor(Colors.rndColor)
            setTitle("Perks.")
            setDescription("""
                This command has been changed.
                Now, you can manage your subscription all in one place.
                Run this command again with one of the subcommands listed below.
                Example: `${ctx.friendlyTrigger}perks link`.
                
                Premium servers are only available as part of our "Server Owners" tier.
                If eligible, by default any servers you own will automatically be upgraded to
                premium. You get **$PREMIUM_SERVERS slots** for upgrading servers you don't own.
                
                `link  ` - Link your Patreon subscription to the bot.
                `add   ` - Link a server to your subscription.
                `remove` - Remove a server from your subscription.
                `list  ` - Lists all servers attached to your subscription.
            """.trimIndent())
        }
    }

    @SubCommand(aliases = ["redeem"], description = "Link your Patreon subscription to the bot.")
    fun link(ctx: Context) {
        ctx.send("Searching for your subscription. This could take up to 30 seconds.")

        BoobBot.pApi.fetchPledgesOfCampaign("1928035").thenAccept {
            if (it.isEmpty()) {
                return@thenAccept ctx.send("Patreon API returned an invalid response. Report this to https://discord.gg/bra.")
            }

            val pledge = it.firstOrNull { u -> u.discordId != null && u.discordId == ctx.author.idLong }
                ?: return@thenAccept ctx.send("Unable to find your subscription. Make sure your Discord account is linked to your Patreon account, whore.")

            if (pledge.isDeclined) {
                return@thenAccept ctx.send("Your payment appears to have been declined. Fix it before attempting to claim your perks, whore.")
            }

            val pledgeAmount = pledge.pledgeCents.toDouble() / 100
            val pledgeFriendly = String.format("%1$,.2f", pledgeAmount)
            ctx.reply("Welcome to the club, whore. Your tier: `${BoobBot.pApi.getDonorType(pledgeAmount)}` ($$pledgeFriendly)")
            BoobBot.database.setDonor(ctx.author.id, pledgeAmount)
        }
    }

    @SubCommand(description = "Link a server to your subscription.")
    fun add(ctx: Context) {
        if (!ctx.isFromGuild) {
            return ctx.send("Run this command in a guild, whore.")
        }

        // check already added
        // check donor type

        BoobBot.database.setPremiumServer(ctx.guild!!.id, ctx.author.idLong)
        ctx.send("sheeeeesh")
    }

    @SubCommand(description = "Remove a server from your subscription.")
    fun remove(ctx: Context) {
        val servers = BoobBot.database.getPremiumServers(ctx.author.idLong)

        if (servers.isEmpty()) {
            return ctx.send("You don't have any premium servers, whore.")
        }

        val guilds = servers.map { (BoobBot.shardManager.getGuildById(it._id)?.name ?: "Inaccessible Server") to it._id }

        ctx.message {
            content("Select the server you want to remove from the list below.\nThis prompt will time out in 30 seconds.")
            row {
                menu("server-selector-${ctx.author.id}") {
                    for ((name, id) in guilds) {
                        addOption(name, id)
                    }
                }
            }
        }
    }

    @SubCommand(description = "Lists all servers attached to your subscription.")
    fun list(ctx: Context) {

    }
}

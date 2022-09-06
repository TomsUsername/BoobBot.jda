package bot.boobbot.commands.dev

import bot.boobbot.BoobBot
import bot.boobbot.entities.framework.Category
import bot.boobbot.entities.framework.interfaces.Command
import bot.boobbot.entities.framework.annotations.CommandProperties
import bot.boobbot.entities.framework.MessageContext
import bot.boobbot.utils.Colors
import bot.boobbot.utils.Utils
import net.dv8tion.jda.api.entities.emoji.Emoji
import org.jetbrains.kotlin.script.jsr223.KotlinJsr223JvmLocalScriptEngineFactory


@CommandProperties(description = "Evaluate code.", category = Category.DEV, developerOnly = true)
class Eval : Command {

    private val engine = KotlinJsr223JvmLocalScriptEngineFactory().scriptEngine
    private val evalThread = Thread("fuck")

    init {
        evalThread.priority = Thread.MIN_PRIORITY
    }

    override fun execute(ctx: MessageContext) {
        val code = ctx.args.joinToString("\n")

        val imports = code.lines()
            .takeWhile { it.startsWith("import ") }
            .joinToString("\n", postfix = "\n")

        val stripped = code.replace("^```\\w+".toRegex(), "")
            .removeSuffix("```")
            .lines()
            .dropWhile { it.startsWith("import ") }
            .joinToString("\n")

        val bindings = mapOf(
            "bb" to BoobBot,
            "ctx" to ctx,
            "jda" to ctx.jda,
            "sm" to BoobBot.shardManager,
            "colors" to Colors,
            "utils" to Utils,
            "self" to BoobBot.database.getUser(ctx.user.id)
        )

        val bindString = bindings.map { "val ${it.key} = bindings[\"${it.key}\"] as ${it.value.javaClass.kotlin.qualifiedName}" }
                .joinToString("\n")
        val bind = engine.createBindings()
        bind.putAll(bindings)

        evalThread.run {
            try {
                val result = engine.eval("$imports$bindString\n$stripped", bind)
                    ?: return ctx.message.addReaction(Emoji.fromUnicode("👌")).queue()
                ctx.channel.sendMessage("```\n$result```").queue(null) {
                    ctx.channel.sendMessage("Response Error\n```\n$it```").queue()
                }
            } catch (e: Exception) {
                val error = e.localizedMessage.split("\n").first()
                ctx.channel.sendMessage("Engine Error\n```\n$error```").queue(null) {
                    ctx.channel.sendMessage("Response Error\n```\n$it```").queue(null, { println("fuck") })
                }
            }
        }
    }
}

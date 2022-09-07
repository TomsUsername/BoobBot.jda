package bot.boobbot.entities.framework.impl

import bot.boobbot.entities.framework.interfaces.Options

class MessageOptions(private val args: MutableList<String>) : Options {
    override fun <T> getByNameOrNext(name: String, resolver: Resolver<T>): T? {
        return args.takeIf { it.isNotEmpty() }?.removeAt(0)?.let(resolver::resolve)
    }

    override fun getOptionStringOrGather(name: String): String {
        return args.joinToString(" ")
    }

    override fun raw() = args
}

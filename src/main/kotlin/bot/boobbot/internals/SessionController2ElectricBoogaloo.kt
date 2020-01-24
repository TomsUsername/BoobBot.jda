package bot.boobbot.internals

import bot.boobbot.BoobBot
import net.dv8tion.jda.api.utils.SessionControllerAdapter

class SessionController2ElectricBoogaloo(controllers: Int = 16) : SessionControllerAdapter() {
    private val controllers: List<SessionController>

    init {
        BoobBot.log.info("Using $controllers SessionControllers.")
        this.controllers = (0..controllers).map { SessionController() }
    }

    override fun appendSession(node: net.dv8tion.jda.api.utils.SessionController.SessionConnectNode) {
        controllerFor(node).appendSession(node)
    }

    override fun removeSession(node: net.dv8tion.jda.api.utils.SessionController.SessionConnectNode) {
        controllerFor(node).removeSession(node)
    }

    private fun controllerFor(node: net.dv8tion.jda.api.utils.SessionController.SessionConnectNode): SessionController {
        return controllers[node.shardInfo.shardId % controllers.size]
    }
}

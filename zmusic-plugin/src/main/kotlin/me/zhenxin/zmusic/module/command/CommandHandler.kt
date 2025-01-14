package me.zhenxin.zmusic.module.command

import me.zhenxin.zmusic.config.Lang
import me.zhenxin.zmusic.module.command.impl.*
import me.zhenxin.zmusic.module.taboolib.sendMsg
import me.zhenxin.zmusic.utils.playMusic
import me.zhenxin.zmusic.utils.sendBridgeToast
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.ProxyPlayer
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.PermissionDefault.*
import taboolib.common.platform.command.mainCommand
import taboolib.common.platform.command.subCommand
import taboolib.common.platform.function.submit

/**
 * 命令处理器
 *
 * @author 真心
 * @since 2021/8/14 20:41
 * @email qgzhenxin@qq.com
 */
@Suppress("unused", "SpellCheckingInspection")
@CommandHeader(
    name = "zm",
    aliases = ["zmusic", "music"],
    permission = "zmusic.use",
    permissionDefault = TRUE
)
object CommandHandler {

    @CommandBody(
        optional = true,
        permission = "zmusic.devloper.test",
        permissionDefault = FALSE
    )
    val test = subCommand {
        execute<ProxyPlayer> { sender, _, _ ->
            submit(async = true) {
                submit(async = true) {
                    sender.sendBridgeToast("Test Toast")
                }
            }
        }
    }


    @CommandBody
    val main = mainCommand {
        execute<ProxyCommandSender> { sender, context, _ ->
            sender.sendMsg(Lang.HELP_TIPS.replace("{0}", context.name))
        }
        incorrectCommand { sender, context, _, _ ->
            val src = context.args()
            val args = src.last().split(" ").toMutableList()
            val command = if (src.size > 1) src.first() + " " else ""
            args[args.lastIndex] = "&c&n${args.last()}"
            val arg = args.joinToString(" ") { it }.trimEnd(' ')
            Lang.COMMAND_INCORRECT_COMMAND.forEach {
                sender.sendMsg(
                    it.replace("{0}", context.name)
                        .replace("{1}", "$command$arg")
                )
            }
        }
        incorrectSender { sender, _ ->
            sender.sendMsg(Lang.COMMAND_INCORRECT_SENDER)
        }
    }

    @CommandBody(
        optional = true,
        permission = "zmusic.user.help",
        permissionDefault = TRUE
    )
    val help = helpCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.user.play",
        permissionDefault = TRUE
    )
    val play = playCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.user.stop",
        permissionDefault = TRUE
    )
    val stop = stopCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.user.music",
        permissionDefault = TRUE
    )
    val music = musicCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.user.search",
        permissionDefault = TRUE
    )
    val search = searchCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.user.queue",
        permissionDefault = TRUE
    )
    val queue = queueCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.user.url",
        permissionDefault = TRUE
    )
    val url = subCommand {
        execute<ProxyPlayer> { sender, _, argument ->
            sender.playMusic(argument.replace("url ", ""))
        }
    }

    @CommandBody(
        optional = true,
        permission = "zmusic.admin.main",
        permissionDefault = OP
    )
    val admin = adminCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.admin.login",
        permissionDefault = OP
    )
    val login = loginCommand

    @CommandBody(
        optional = true,
        permission = "zmusic.admin.reload",
        permissionDefault = OP
    )
    val reload = reloadCommand
}
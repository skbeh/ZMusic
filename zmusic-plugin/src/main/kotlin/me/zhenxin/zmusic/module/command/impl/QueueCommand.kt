package me.zhenxin.zmusic.module.command.impl

import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.subCommand

/**
 * 队列命令
 *
 * @author 真心
 * @since 2021/8/23 0:36
 * @email qgzhenxin@qq.com
 */
val queueCommand = subCommand {
    dynamic(comment = "Action") {
        suggestion<ProxyCommandSender> { _, _ ->
            listOf(
                "add",
                "remove",
                "on",
                "off"
            )
        }
    }
}
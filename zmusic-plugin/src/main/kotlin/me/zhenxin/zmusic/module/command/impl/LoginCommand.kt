package me.zhenxin.zmusic.module.command.impl

import me.zhenxin.zmusic.enums.MusicPlatform
import me.zhenxin.zmusic.enums.getPlatformNamesWithSupportAccount
import me.zhenxin.zmusic.login.NeteaseLogin
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.subCommand

/**
 * 登录命令
 *
 * @author 真心
 * @since 2021/9/27 21:04
 * @email qgzhenxin@qq.com
 */
val loginCommand = subCommand {
    dynamic(comment = "平台") {
        suggestion<ProxyCommandSender> { _, _ ->
            getPlatformNamesWithSupportAccount()
        }
        execute<ProxyCommandSender> { sender, _, argument ->
            val arguments = argument.split(" ")
            val platform = MusicPlatform.valueOf(arguments[0].uppercase())
            when (platform) {
                // 暂时实验性 后续加入语言文件
                MusicPlatform.NETEASE -> {
                    NeteaseLogin.qrcode(sender)
                }

                else -> return@execute
            }
        }
    }
}

private var phone = 0L
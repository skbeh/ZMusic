package me.zhenxin.zmusic.module.command.impl

import me.zhenxin.zmusic.logger
import me.zhenxin.zmusic.module.Lang
import me.zhenxin.zmusic.module.config
import me.zhenxin.zmusic.module.taboolib.sendMsg
import me.zhenxin.zmusic.utils.colored
import me.zhenxin.zmusic.utils.loginNetease
import me.zhenxin.zmusic.utils.setLocale
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.subCommand
import taboolib.common.platform.function.submit
import taboolib.module.lang.Language

/**
 * 重载命令
 *
 * @author 真心
 * @since 2021/9/23 11:11
 * @email qgzhenxin@qq.com
 */
val reloadCommand = subCommand {
    execute<ProxyCommandSender> { sender, _, _ ->
        config.reload()
        Language.reload()
        setLocale()
        sender.sendMsg(Lang.COMMAND_RELOAD_SUCCESS)
        submit(async = true) {
            logger.info("&a正在尝试登录网易云音乐...".colored())
            val result = loginNetease()
            logger.info(result.message.colored())
        }
    }
}
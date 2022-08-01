package me.zhenxin.zmusic.module.command.impl

import me.zhenxin.zmusic.utils.stopMusic
import taboolib.common.platform.ProxyPlayer
import taboolib.common.platform.command.subCommand

val stopCommand = subCommand {
    execute<ProxyPlayer> { sender, _, _ ->
        sender.stopMusic()
    }
}
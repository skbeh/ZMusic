package me.zhenxin.zmusic.module.taboolib.impl

import me.zhenxin.zmusic.module.taboolib.PluginMessage
import net.md_5.bungee.api.connection.ProxiedPlayer
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformImplementation
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.ProxyPlayer
import taboolib.platform.BungeePlugin

/**
 * 插件消息 Bungee 实现
 *
 * @author 真心
 * @since 2021/8/16 17:21
 * @email qgzhenxin@qq.com
 */

@PlatformImplementation(Platform.BUNGEE)
class PluginMessageBungeeImpl : PluginMessage {
    private val plugin by lazy { BungeePlugin.getInstance() }
    override fun registerChannel(channel: String) {
        plugin.proxy.registerChannel(channel)
    }

    override fun sendMessage(sender: ProxyPlayer, channel: String, data: ByteArray) {
        val player by lazy { sender.cast<ProxiedPlayer>() }
        player.sendData(channel, data)
    }
}
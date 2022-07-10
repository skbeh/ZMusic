package me.zhenxin.zmusic.status

import me.zhenxin.zmusic.api.MusicInfo
import me.zhenxin.zmusic.bossbar.BossBar
import me.zhenxin.zmusic.music.MusicPlayer
import taboolib.common.platform.ProxyPlayer

/**
 * 玩家状态
 *
 * @author 真心
 * @since 2022/7/5 14:30
 * @email qgzhenxin@qq.com
 */
object PlayerState {
    val MUSIC_PLAYER = mutableMapOf<ProxyPlayer, MusicPlayer>()
    val BOSS_BAR = mutableMapOf<ProxyPlayer, BossBar>()
    val PLAYING = mutableMapOf<ProxyPlayer, Boolean>()
    val MUSIC = mutableMapOf<ProxyPlayer, MusicInfo>()
    val CURRENT_LYRIC = mutableMapOf<ProxyPlayer, String>()
    val CURRENT_TIME = mutableMapOf<ProxyPlayer, String>()
}
package me.zhenxin.zmusic.exception

/**
 * 自定义异常
 *
 * @author 真心
 * @since 2021/7/15 12:47
 * @email qgzhenxin@qq.com
 */
class ZMusicException(
    override val message: String = "ZMusic Internal Exception"
) : RuntimeException()
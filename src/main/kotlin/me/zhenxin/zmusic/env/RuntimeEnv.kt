package me.zhenxin.zmusic.env

import taboolib.common.env.RuntimeDependencies
import taboolib.common.env.RuntimeDependency

/**
 * 运行环境依赖声明
 *
 * @author 真心
 * @since 2021/8/17 14:48
 * @email qgzhenxin@qq.com
 */
@Suppress("unused", "SpellCheckingInspection")
@RuntimeDependencies(
    RuntimeDependency(
        value = "!cn.hutool:hutool-json:${Versions.hutool}",
        test = "!cn.hutool.json.JSONUtil"
    ),
    RuntimeDependency(
        value = "!cn.hutool:hutool-http:${Versions.hutool}",
        test = "!cn.hutool.http.HttpUtil"
    ),
    RuntimeDependency(
        value = "!cn.hutool:hutool-crypto:${Versions.hutool}",
        test = "!cn.hutool.crypto.SecureUtil"
    ),
    RuntimeDependency(
        value = "!org.ktorm:ktorm-core:${Versions.ktorm}",
        test = "org.ktorm.database.Database",
        relocate = ["!kotlin.", "!kotlin@kotlin_version_escape@."]
    ),
    RuntimeDependency(
        value = "!org.ktorm:ktorm-support-sqlite:${Versions.ktorm}",
        test = "org.ktorm.support.sqlite.SQLiteDialect",
        relocate = ["!kotlin.", "!kotlin@kotlin_version_escape@."]
    ),
    RuntimeDependency(
        value = "!org.ktorm:ktorm-support-mysql:${Versions.ktorm}",
        test = "org.ktorm.support.mysql.MySqlDialect",
        relocate = ["!kotlin.", "!kotlin@kotlin_version_escape@."]
    ),
    RuntimeDependency(
        value = "!me.zhenxin:adventure-text-minimessage:4.2.0-SNAPSHOT",
        test = "!me.zhenxin.adventure.text.minimessage.MiniMessage",
        repository = "https://gitee.com/RealHeart/Maven/raw/master"
    )
)
class RuntimeEnv
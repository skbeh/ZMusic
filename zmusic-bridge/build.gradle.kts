@file:Suppress("SpellCheckingInspection")

version = "3.0.0"

repositories {
    // TabooLib
    maven("https://repo.tabooproject.org/repository/releases")
}

dependencies {
    libs.bundles.nms.get().forEach {
        compileOnly(
            group = it.module.group,
            name = it.module.name,
            version = it.versionConstraint.toString(),
            classifier = "universal"
        )
    }
    compileOnly(libs.nms.legacy)
    compileOnly(libs.spigot)

    compileOnly("me.clip:placeholderapi:2.11.2")
    compileOnly("org.jetbrains:annotations:23.0.0")
}

tasks.processResources {
    inputs.property("version", version)

    filesMatching("plugin.yml") {
        expand(mapOf("version" to version))
    }
}

tasks.jar {
    archiveBaseName.set("ZMusicBridge")
}

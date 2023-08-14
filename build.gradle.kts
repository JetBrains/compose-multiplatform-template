plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/") // to test with kotlin dev builds
        mavenLocal()
    }

    afterEvaluate {
        val project = this
        val compilerPluginVersion = project.properties["compose.kotlinCompilerPluginVersion"] as? String
        val kotlinVersion = project.properties["kotlin.version"] as? String
        project.extensions.findByType<org.jetbrains.compose.ComposeExtension>()?.also {
            if (!compilerPluginVersion.isNullOrEmpty()) {
                println("${project.name} is using compilerPluginVersion = $compilerPluginVersion")
                it.kotlinCompilerPlugin.set(compilerPluginVersion)
                it.kotlinCompilerPluginArgs.add("suppressKotlinVersionCompatibilityCheck=$kotlinVersion")
            }
        }
    }
}
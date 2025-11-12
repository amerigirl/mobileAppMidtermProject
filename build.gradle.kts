plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
// build.gradle.kts (Project level)
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val nav_version = "2.9.6" // Use the latest stable version
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}
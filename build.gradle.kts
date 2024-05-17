// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.daggerHiltAndroidPlugin) apply false
    alias(libs.plugins.jetbrainskotlinkapt) apply false
    alias(libs.plugins.googleFirebaseFirebasePerf) apply false
    alias(libs.plugins.googleGmsGoogleServices) apply false
    //alias(libs.plugins.kspPlugin) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.googleGradleSecret)
        classpath(libs.navigation)
        classpath(libs.gradle)
        classpath(libs.google.services)
        classpath(libs.firebase.crashlytics.gradle)
    }
}

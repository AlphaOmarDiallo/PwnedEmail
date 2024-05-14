
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.daggerHiltAndroidPlugin)
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    alias(libs.plugins.jetbrainskotlinkapt)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    //alias(libs.plugins.kspPlugin)
}

android {
    namespace = "com.alphaomardiallo.pawnedemail"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alphaomardiallo.pawnedemail"
        minSdk = 26
        targetSdk = 34
        versionCode = 2
        versionName = "1.0.1"

        testInstrumentationRunner = "com.alphaomardiallo.pawnedemail.PawnedEmailTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }

    secrets {
        propertiesFileName = "secrets.properties"
        defaultPropertiesFileName = "local.defaults.properties"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.compose.lifecycle)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.dagger.hilt.android)
    implementation(libs.dagger.hilt.nav.compose)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    kapt(libs.dagger.hilt.compiler)
    kaptAndroidTest(libs.dagger.hilt.compiler)
    testImplementation(libs.dagger.hilt.android.testing)
    testAnnotationProcessor(libs.dagger.hilt.compiler)
    androidTestImplementation(libs.dagger.hilt.android.testing)
    androidTestAnnotationProcessor(libs.dagger.hilt.compiler)

    implementation(libs.navigation.ui)
    implementation(libs.navigation.compose)
    androidTestImplementation(libs.navigation.testing)

    implementation(platform(libs.squareup.okhttp.bom))
    implementation(libs.squareup.okhttp)
    implementation(libs.squareup.okhttp.interceptor)
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.moshi)
    implementation(libs.squareup.moshi.converter)
    testImplementation(libs.squareup.okhttp.mockwebserver)

    implementation(libs.io.coil)

    implementation(libs.jakewharthon.timber)

    implementation(libs.room)
    implementation(libs.room.ktx)
    implementation(libs.room.compiler) {
        exclude(group = "com.intellij", module = "annotations")
    }
    kapt(libs.room.compiler)
    annotationProcessor(libs.room.compiler)
    testImplementation(libs.room.testing)

    implementation(libs.gson)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //debugImplementation(libs.squareup.leakcanary)
    testImplementation(libs.truth)
    androidTestImplementation(libs.truth)
}

kapt {
    arguments {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

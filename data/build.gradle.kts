version = ProjectSettings.Data.versionName

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android-extensions")
    id("maven-publish")
}

android {
    compileSdkVersion(SdkVersions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(SdkVersions.minSdkVersion)
        targetSdkVersion(SdkVersions.targetSdkVersion)

        versionCode = ProjectSettings.Data.versionCode
        versionName = ProjectSettings.Data.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

dependencies {
    // Module
    implementation(project(":native-lib"))
    implementation(project(":core"))

    // AndroidX
    implementation(Dependencies.AndroidX.Startup.startup)

    // Google
    api(Dependencies.Google.Places.places)

    // Hilt
    implementation(Dependencies.Dagger.hiltAndroid)
    kapt(Dependencies.Dagger.hiltAndroidCompiler)

    // Test
    testImplementation(Dependencies.JUnit.jUnit)
    androidTestImplementation(Dependencies.AndroidX.Test.runner)
    androidTestImplementation(Dependencies.AndroidX.Test.Ext.jUnit)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
            }
        }
    }
}

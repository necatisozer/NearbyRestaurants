version = ProjectSettings.Navigation.versionName

plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
    id("maven-publish")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(SdkVersions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(SdkVersions.minSdkVersion)
        targetSdkVersion(SdkVersions.targetSdkVersion)

        versionCode = ProjectSettings.Navigation.versionCode
        versionName = ProjectSettings.Navigation.versionName

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
    // Kotlin
    implementation(kotlin("stdlib-jdk7"))

    // Java
    coreLibraryDesugaring(Dependencies.Tools.desugarJdkLibs)

    // AndroidX
    api(Dependencies.AndroidX.Navigation.fragment)
    api(Dependencies.AndroidX.Navigation.ui)

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

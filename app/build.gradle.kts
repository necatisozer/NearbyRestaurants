plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("kotlin-android-extensions")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(SdkVersions.compileSdkVersion)

    defaultConfig {
        minSdkVersion(SdkVersions.minSdkVersion)
        targetSdkVersion(SdkVersions.targetSdkVersion)

        applicationId = ProjectSettings.App.applicationId
        versionCode = ProjectSettings.App.versionCode
        versionName = ProjectSettings.App.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        coreLibraryDesugaringEnabled = true
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

    ndkVersion = SdkVersions.ndkVersion

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
        lintConfig = file(".lint/lint.xml")
    }
}

dependencies {
    // Java
    coreLibraryDesugaring(Dependencies.Tools.desugarJdkLibs)

    // Module
    implementation(project(":library"))
    implementation(project(":data"))
    implementation(project(":native-lib"))
    implementation(project(":domain"))
    implementation(project(":core"))
    implementation(project(":database"))
    implementation(project(":navigation"))
    implementation(project(":feature:restaurants"))

    // KotlinX
    implementation(Dependencies.KotlinX.Serialization.runtime)

    // AndroidX
    implementation(Dependencies.AndroidX.Activity.activity)
    implementation(Dependencies.AndroidX.Appcompat.appcompat)
    implementation(Dependencies.AndroidX.Core.core)
    implementation(Dependencies.AndroidX.Fragment.fragment)
    implementation(Dependencies.AndroidX.Hilt.viewModel)
    kapt(Dependencies.AndroidX.Hilt.compiler)

    // Material
    implementation(Dependencies.Material.material)

    // Hilt
    implementation(Dependencies.Dagger.hiltAndroid)
    kapt(Dependencies.Dagger.hiltAndroidCompiler)

    // Test
    testImplementation(Dependencies.JUnit.jUnit)
    androidTestImplementation(Dependencies.AndroidX.Test.Ext.jUnit)
    androidTestImplementation(Dependencies.AndroidX.Test.rules)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.core)
}

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "com.android.library") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
            if (requested.id.id == "com.android.application") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()
    }
}

rootProject.name = ("nearby-restaurants")

include(
    ":app",
    ":library",
    ":data",
    ":native-lib",
    ":domain",
    ":core",
    ":database",
    ":navigation",
    ":feature:restaurants"
)

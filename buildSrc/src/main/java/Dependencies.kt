object Dependencies {
    object AndroidX {
        object Activity {
            private const val version = "1.1.0"
            const val activity = "androidx.activity:activity-ktx:$version"
        }

        object Appcompat {
            private const val version = "1.3.0-alpha01"
            const val appcompat = "androidx.appcompat:appcompat:$version"
        }

        object ConstraintLayout {
            private const val version = "2.0.0-beta8"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
        }

        object Core {
            private const val version = "1.4.0-alpha01"
            const val core = "androidx.core:core-ktx:$version"
        }

        object Fragment {
            private const val version = "1.3.0-alpha06"
            const val fragment = "androidx.fragment:fragment-ktx:$version"
            const val testing = "androidx.fragment:fragment-testing:$version"
        }

        object Hilt {
            private const val version = "1.0.0-alpha01"
            const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }

        object Lifecycle {
            private const val version = "2.3.0-alpha05"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelSavedState =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
            const val common = "androidx.lifecycle:lifecycle-common-java8:$version"
        }

        object Navigation {
            const val version = "2.3.0"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val dynamicFeaturesFragment =
                "androidx.navigation:navigation-dynamic-features-fragment:$version"
            const val testing = "androidx.navigation:navigation-testing:$version"
        }

        object RecyclerView {
            private const val version = "1.2.0-alpha04"
            const val recyclerview = "androidx.recyclerview:recyclerview:$version"
        }

        object Room {
            private const val version = "2.2.5"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val testing = "androidx.room:room-testing:$version"
        }

        object Startup {
            private const val version = "1.0.0-alpha01"
            const val startup = "androidx.startup:startup-runtime:$version"
        }

        object Test {
            private const val version = "1.3.0-rc01"

            const val rules = "androidx.test:rules:$version"
            const val runner = "androidx.test:runner:$version"

            object Ext {
                private const val version = "1.1.2-rc01"
                const val jUnit = "androidx.test.ext:junit:$version"
            }

            object Espresso {
                private const val version = "3.3.0-rc01"
                const val core = "androidx.test.espresso:espresso-core:$version"
            }
        }
    }

    object Material {
        private const val version = "1.3.0-alpha01"
        const val material = "com.google.android.material:material:$version"
    }

    object KotlinX {
        object Coroutines {
            private const val version = "1.3.8"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }

        object Serialization {
            private const val version = "0.20.0"
            const val runtime = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:$version"
        }
    }

    object Dagger {
        const val version = "2.28-alpha"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    }

    object RetrofitKotlinXSerializationConverter {
        private const val version = "0.5.0"
        const val serializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$version"
    }

    object OkHttp {
        private const val version = "4.8.0"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Tools {
        private const val version = "1.0.9"
        const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:$version"
    }

    object JUnit {
        private const val version = "4.13"
        const val jUnit = "junit:junit:$version"
    }
}
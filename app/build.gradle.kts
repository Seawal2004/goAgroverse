plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.goagroverse"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.goagroverse"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Android Core Libraries
    implementation(platform("androidx.compose:compose-bom:2023.10.00"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation("androidx.navigation:navigation-compose:2.7.2")
    implementation(libs.androidx.material3.android) // Material Design 3

    // Networking: Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Core library for HTTP requests
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // JSON parser for Retrofit

    // Coroutine Support for Retrofit
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Coroutine support

    // Dependency Injection: Hilt
    implementation("com.google.dagger:hilt-android:2.48.1") // Hilt DI
    kapt("com.google.dagger:hilt-android-compiler:2.48.1") // Hilt Compiler

    // Logging for Network Requests
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.11") // Log HTTP calls

    // Compose-specific libraries for UI
    implementation("androidx.compose.runtime:runtime-livedata:1.5.3") // LiveData integration with Compose

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Debugging Compose UI
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

plugins {
    id("cmessenger.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "st.slex.core_model"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)
    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.androidx.test.ext)
}
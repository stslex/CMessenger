import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("cmessenger.android.library")
    id("cmessenger.android.library.compose")
    id("cmessenger.android.library.jacoco")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val Properties.apiKey: String
    get() {
        val localProperties = project.rootProject.file("local.properties")
        load(localProperties.inputStream())
        return getProperty("API_SUCCESS_KEY")
    }

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        buildConfigField("String", "API_KEY", Properties().apiKey)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
    namespace = "st.slex.feature_photos"
}

dependencies {
    implementation(project(":core-navigation"))
    implementation(project(":core-ui"))
    implementation(project(":utils-ui"))

    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.androidx.window.manager)
    implementation(libs.material3)
    implementation(libs.androidx.profileinstaller)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.kotlinx.coroutines.test)
    api(libs.androidx.test.ext)
}
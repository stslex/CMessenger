plugins {
    id("cmessenger.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    kotlin("plugin.serialization")
}

dependencies {
    implementation(project(":core-common"))

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)
    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.androidx.test.ext)
}

android {
    namespace = "st.slex.core_model"
}
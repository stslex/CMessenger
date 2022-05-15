plugins {
    id("cmessenger.android.library")
    id("cmessenger.android.library.jacoco")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.ksp)
    id("cmessenger.spotless")
}

dependencies {
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
android {
    namespace = "st.slex.core_navigation"
}

plugins {
    id("cmessenger.android.library")
    id("cmessenger.android.library.compose")
    id("cmessenger.android.library.jacoco")
}

dependencies {
    implementation(project(":core-ui"))
}

android {
    namespace = "st.slex.utils_ui"
}
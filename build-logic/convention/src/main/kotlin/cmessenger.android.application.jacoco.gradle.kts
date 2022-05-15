import st.slex.cmessenger.configureJacoco

plugins {
    id("com.android.application")
    jacoco
}

android {
    androidComponents {
        configureJacoco(this)
    }
}
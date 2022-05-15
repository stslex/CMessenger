import st.slex.cmessenger.configureJacoco

plugins {
    id("com.android.library")
    jacoco
}

android {
    androidComponents {
        configureJacoco(this)
    }
}
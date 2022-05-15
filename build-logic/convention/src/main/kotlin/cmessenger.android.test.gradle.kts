import st.slex.cmessenger.configureKotlinAndroid

plugins {
    id("com.android.test")
    kotlin("android")
}

android {
    configureKotlinAndroid(this)

    defaultConfig {
        targetSdk = 31
    }
}

plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }

android {

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "biz.shikuro.rootoverlay"
    compileSdk = 35
    defaultConfig { applicationId = "biz.shikuro.rootoverlay"; minSdk = 26; targetSdk = 35; versionCode = 1; versionName = "1.0" }
}

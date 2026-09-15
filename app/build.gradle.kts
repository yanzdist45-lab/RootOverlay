plugins { id("com.android.application"); id("org.jetbrains.kotlin.android") }

android {
    namespace = "biz.shikuro.rootoverlay"
    compileSdk = 35
    defaultConfig { applicationId = "biz.shikuro.rootoverlay"; minSdk = 26; targetSdk = 35; versionCode = 1; versionName = "1.0" }
}

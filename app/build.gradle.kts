plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.atakaya.quoteofday"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.atakaya.quoteofday"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField( "String", "BASE_URL", "\"https://get-quotes-api.p.rapidapi.com\"")
        buildConfigField( "String", "XRapidAPIKey", "\"d513fba479msh425c19697c8daafp103cd5jsn7e58d8ac9ff8\"")
        buildConfigField( "String", "XRapidAPIHost", "\"get-quotes-api.p.rapidapi.com\"")

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
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.constrantlayout.compose)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //navigation
    implementation(libs.androidx.navigation)

    //koin
    implementation(libs.android.koin)
    implementation(libs.androidx.koin.compose)

    //room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    //okhttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    //test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
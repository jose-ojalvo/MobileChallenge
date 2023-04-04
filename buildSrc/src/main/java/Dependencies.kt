/**
 *   @author jojalvo
 *   @since 27/3/23
 *   @email josealejandro025@gmail.com
 */
object Dependencies {
    const val testRunnerPackage = "androidx.test.runner.AndroidJUnitRunner"
    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinKapt = "kotlin-kapt"
    const val hiltPlugin = "dagger.hilt.android.plugin"
    const val symbolPlugin = "com.google.devtools.ksp"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"
    const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltAndroid}"
    const val hiltAndroidCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltAndroid}"
    const val kotlinSymbolProcessing =
        "com.google.devtools.ksp:symbol-processing-gradle-plugin:${Versions.kotlinSymbolProcessing}"
    const val junit = "junit:junit:${Versions.junit}"
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinPlugin}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragmentKtx = "androidx.fragment:fragment:${Versions.fragmentKtx}"
    const val savedState = "androidx.savedstate:savedstate-ktx:${Versions.savedState}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val androidPaging = "androidx.paging:paging-runtime-ktx:${Versions.androidPaging}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val material3Compose = "androidx.compose.material3:material3:${Versions.material3}"
    const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val foundation = "androidx.compose.foundation:foundation:${Versions.foundation}"
    const val materialIconCore =
        "androidx.compose.material:material-icons-core:${Versions.materialIcons}"
    const val materialIconExtended =
        "androidx.compose.material:material-icons-extended:${Versions.materialIcons}"
    const val activity = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModelCompose}"
    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintCompose}"
    const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottieCompose}"
    const val paging = "androidx.paging:paging-compose:${Versions.pagingCompose}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val swiperefresh = "com.google.accompanist:accompanist-swiperefresh:${Versions.swipe}"
    const val systemuicontroller =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.systemController}"
    const val insets = "com.google.accompanist:accompanist-insets:${Versions.systemController}"
    const val placeholderMaterial =
        "com.google.accompanist:accompanist-placeholder-material:${Versions.systemController}"
    const val navigationMaterial =
        "com.google.accompanist:accompanist-navigation-material:${Versions.systemController}"
    const val permissions =
        "com.google.accompanist:accompanist-permissions:${Versions.systemController}"
    const val pager = "com.google.accompanist:accompanist-pager:${Versions.systemController}"
    const val indicators =
        "com.google.accompanist:accompanist-pager-indicators:${Versions.systemController}"
    const val webview = "com.google.accompanist:accompanist-webview:${Versions.webview}"
    const val testJunit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val testManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    const val destinationAnimation =
        "io.github.raamcosta.compose-destinations:animations-core:${Versions.destination}"
    const val destinationCore =
        "io.github.raamcosta.compose-destinations:core:${Versions.destination}"
    const val destinationKsp =
        "io.github.raamcosta.compose-destinations:ksp:${Versions.destination}"
}
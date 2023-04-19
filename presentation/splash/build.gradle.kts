plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
}

configureAndroidLibrary(Namings.splashModule)

dependencies {
    TEST_UTILS
    UTILS
    USE_CASE
    FRAMEWORK
    addCommonDependencies()
    addHiltDependencies()
    implementation(Dependencies.splashscreen)
}
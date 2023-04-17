plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
}

configureAndroidLibrary(Namings.splashModule)

dependencies {
    UTILS
    USE_CASE
    FRAMEWORK
    addCommonDependencies()
    addHiltDependencies()
    implementation(Dependencies.splashscreen)
}
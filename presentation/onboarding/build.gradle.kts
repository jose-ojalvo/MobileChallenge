plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
}

configureAndroidLibrary(Namings.onBoardingModule)

configComposeProject()

dependencies {
    PROVIDER
    USE_CASE
    FRAMEWORK
    THEME
    UTILS
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
}
plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.settingsModule)

configComposeProject()

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "settings")
}

dependencies {
    CONSTANTS
    USE_CASE
    FRAMEWORK
    THEME
    TEST_UTILS
    PROVIDER
    UTILS
    COMPONENT
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addNavigationDependencies()
}
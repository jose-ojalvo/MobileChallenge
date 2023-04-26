plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.homeModule)

configComposeProject()

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "home")
}

dependencies {
    FRAMEWORK
    PROVIDER
    SETTINGS
    TEST_UTILS
    THEME
    USE_CASE
    USERS
    UTILS
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addNavigationDependencies()
}

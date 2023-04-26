plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.usersModule)

configComposeProject()

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "users")
}

dependencies {
    COMPONENT
    CONSTANTS
    ENTITY
    FRAMEWORK
    PROVIDER
    SETTINGS
    TEST_UTILS
    THEME
    USE_CASE
    UTILS
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addNavigationDependencies()
}
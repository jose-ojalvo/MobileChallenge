plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.favoritesModule)

configComposeProject()

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "favorites")
}

android {

}

dependencies {
    CONSTANTS
    USE_CASE
    FRAMEWORK
    THEME
    TEST_UTILS
    PROVIDER
    UTILS
    ENTITY
    COMPONENT
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addNavigationDependencies()
}
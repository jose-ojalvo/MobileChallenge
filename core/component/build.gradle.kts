plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
}

configureAndroidLibrary(Namings.componentModule)

configComposeProject()

dependencies {
    THEME
    FRAMEWORK
    addCommonDependencies()
    addComposeDependencies()
}

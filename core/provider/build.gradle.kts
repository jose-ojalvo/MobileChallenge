plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
}

configureAndroidLibrary(Namings.providerModule)

configComposeProject()

dependencies {
    UTILS
    addCommonDependencies()
    addComposeDependencies()
}
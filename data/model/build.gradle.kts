plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.modelModule)

dependencies {
    ENTITY
    UTILS
    TEST_UTILS
    addCommonDependencies()
    addStorageDependencies()
    addNetworkDependency()
    api(Dependencies.json)
}
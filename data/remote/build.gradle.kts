plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.remoteModule)

dependencies {
    MODEL
    FRAMEWORK
    TEST_UTILS
    addCommonDependencies()
    addHiltDependencies()
    addNetworkDependency()
}
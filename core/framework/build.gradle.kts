plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.frameworkModule)
configComposeProject()

dependencies {
    UTILS
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addPreferenceDependencies()
    implementation(Dependencies.hiltAndroidTesting)
    addStorageDependencies()
    addNetworkDependency()
}
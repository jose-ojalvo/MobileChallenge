plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.localModule)

dependencies {
    UTILS
    MODEL
    FRAMEWORK
    TEST_UTILS
    ENTITY
    addCommonDependencies()
    addHiltDependencies()
    addTestDependencies()
    addStorageDependencies()
    addPreferenceDependencies()
}
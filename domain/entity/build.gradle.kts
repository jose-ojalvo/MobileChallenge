plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.parcelizePlugin)
}

configureAndroidLibrary(Namings.entityModule)

dependencies {
    TEST_UTILS
    addCommonDependencies()
}
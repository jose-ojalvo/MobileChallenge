plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
}

configureAndroidLibrary(Namings.repositoryModule)

dependencies {
    FRAMEWORK
    CONSTANTS
    LOCAL
    REMOTE
    MODEL
    ENTITY
    TEST_UTILS
    addCommonDependencies()
    addHiltDependencies()
    implementation(Dependencies.datastorePref)
}
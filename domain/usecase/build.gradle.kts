plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
}

configureAndroidLibrary(Namings.usecaseModule)

dependencies {
    ENTITY
    MODEL
    REPOSITORY
    FRAMEWORK
    TEST_UTILS
    addCommonDependencies()
    addHiltDependencies()
}
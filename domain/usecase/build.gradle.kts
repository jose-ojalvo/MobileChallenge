plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
}

configureAndroidLibrary(Namings.usecaseModule)

dependencies {
    REPOSITORY
    FRAMEWORK
    addCommonDependencies()
    addHiltDependencies()
}
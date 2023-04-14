plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
}

configureAndroidLibrary(Namings.repositoryModule)

dependencies {
    CONSTANTS
    FRAMEWORK
    addCommonDependencies()
    addHiltDependencies()
    implementation(Dependencies.datastorePref)
}
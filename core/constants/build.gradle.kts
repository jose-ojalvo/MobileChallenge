plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
}

configureAndroidLibrary(Namings.constantsModule)

dependencies {
    addCommonDependencies()
}
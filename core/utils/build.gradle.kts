plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
}

configureAndroidLibrary(Namings.utilsModule)

dependencies {
    CONSTANTS
    addCommonDependencies()
    addComposeDependencies()
    implementation(Dependencies.moshi)
}
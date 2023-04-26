plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
}

configureAndroidLibrary(Namings.utilsModule)

dependencies {
    ENTITY
    CONSTANTS
    addCommonDependencies()
    addComposeDependencies()
    implementation(Dependencies.moshi)
}
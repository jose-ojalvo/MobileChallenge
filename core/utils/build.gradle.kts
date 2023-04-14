plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
}

configureAndroidLibrary(Namings.utilsModule)

dependencies {
    addCommonDependencies()
    addComposeDependencies()
    implementation(Dependencies.moshi)
}
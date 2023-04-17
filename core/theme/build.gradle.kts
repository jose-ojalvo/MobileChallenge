plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
}

configureAndroidLibrary(Namings.themeModule)

configComposeProject()

dependencies {
    addCommonDependencies()
    addComposeDependencies()
    implementation(Dependencies.splashscreen)
    implementation(Dependencies.kotlinLib)
}
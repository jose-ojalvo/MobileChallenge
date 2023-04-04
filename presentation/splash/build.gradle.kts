plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
}

configureAndroidLibrary(Namings.splashModule)

dependencies {
    addCommonDependencies()
    addHiltDependencies()
    implementation(Dependencies.splashscreen)
}
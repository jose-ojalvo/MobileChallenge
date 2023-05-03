plugins {
    id(Dependencies.library)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.symbolPlugin)
}

configureAndroidLibrary(Namings.testutilsModule)

dependencies {
    addCommonDependencies()
    implementation(Dependencies.junit)
    implementation(Dependencies.coroutinesTest)
    implementation(Dependencies.mockk)
    implementation(Dependencies.robolectric)
    implementation(Dependencies.moshi)
    addNetworkDependency()
    api(Dependencies.mockWebServer)
    implementation(Dependencies.hamcrest)
}
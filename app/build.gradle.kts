plugins {
    id(Dependencies.application)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.kotlinKapt)
    id(Dependencies.hiltPlugin)
    id(Dependencies.symbolPlugin)
}

android {
    configDefaultSettings()
    configBuildTypes()
    configKotlinOptions(tasks)
    configPackageOptions()
    configComposeProject()
    configTesting()
}

dependencies {
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addNavigationDependencies()
    addTestDependencies()
}
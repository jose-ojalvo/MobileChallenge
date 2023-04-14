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
    configComposeProject()
    configTesting()
}

dependencies {
    addModuleDependencies()
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addNavigationDependencies()
    addTestDependencies()
}
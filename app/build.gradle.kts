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

android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName(BuildData.main) {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
        substitute(module(Dependencies.hamcrestLibrary)).using(module(Dependencies.junit))
    }
}

dependencies {
    addModuleDependencies()
    addCommonDependencies()
    addHiltDependencies()
    addComposeDependencies()
    addNavigationDependencies()
}
/**
 *   @author jojalvo
 *   @since 28/3/23
 *   @email josealejandro025@gmail.com
 */
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.api.tasks.TaskContainer

fun BaseAppModuleExtension.configDefaultSettings() {
    compileSdk = BuildConfig.compileSdk
    defaultConfig {
        applicationId = Namings.appModule
        minSdk = BuildConfig.minSdk
        targetSdk = BuildConfig.targetSdk
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

        testInstrumentationRunner = Dependencies.testRunnerPackage
    }
}

fun BaseAppModuleExtension.configComposeProject() {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinExtensionVersion
    }
    configPackageOptions()
}

fun BaseAppModuleExtension.configPackageOptions() {
    packagingOptions {
        resources.excludes.apply {
            add(Excludes.kotlinModule)
            add(Excludes.metaInfAl2)
            add(Excludes.metaInfAl21)
        }
    }
}

fun BaseAppModuleExtension.configTesting() {
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

fun BaseAppModuleExtension.configKotlinOptions(tasks: TaskContainer) {
    compileOptions {
        sourceCompatibility(Versions.javaVersion)
        targetCompatibility(Versions.javaVersion)
    }
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
        kotlinOptions {
            jvmTarget = Versions.javaVersion.toString()
            freeCompilerArgs = listOf(BuildConfig.xInlineClasses)
        }
    }
}
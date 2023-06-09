import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 *   @author jojalvo
 *   @since 4/4/23
 *   @email josealejandro025@gmail.com
 */

fun Project.configureAndroidLibrary(name: String) {
    androidLibrary {
        namespace = name
        compileSdk = BuildConfig.compileSdk

        defaultConfig {
            minSdk = BuildConfig.minSdk
            targetSdk = BuildConfig.targetSdk

            testInstrumentationRunner = Dependencies.testRunnerPackage
            consumerProguardFiles(BuildData.consumerRules)
        }

        compileOptions {
            sourceCompatibility = Versions.javaVersion
            targetCompatibility = Versions.javaVersion
        }

        testOptions {
            unitTests.isIncludeAndroidResources = true
        }

        kotlinOptions {
            jvmTarget = Versions.javaVersion.toString()
        }
    }
}

fun Project.configComposeProject() {
    androidLibrary {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Versions.kotlinExtensionVersion
        }
        configPackageOptions()
    }
}

fun LibraryExtension.configPackageOptions() {
    packagingOptions {
        resources.excludes.apply {
            add(Excludes.kotlinModule)
            add(Excludes.metaInfAl2)
            add(Excludes.metaInfAl21)
        }
    }
}

/**
 * Configures the [android][LibraryExtension] extension.
 */
fun Project.androidLibrary(configure: Action<LibraryExtension>) =
    (this as ExtensionAware).extensions.configure("android", configure)

/**
 * Configures the [kotlinOptions][KotlinJvmOptions] extension.
 */
fun LibraryExtension.kotlinOptions(configure: Action<KotlinJvmOptions>) =
    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)


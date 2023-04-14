/**
 *   @author jojalvo
 *   @since 28/3/23
 *   @email josealejandro025@gmail.com
 */
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addCommonDependencies() {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.coroutineCore)
    implementation(Dependencies.coroutineAndroid)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.activityKtx)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.savedState)
    implementation(Dependencies.timber)
    implementation(Dependencies.androidPaging)
    implementation("com.squareup:javapoet:1.13.0")
}

fun DependencyHandler.addHiltDependencies() {
    implementation(Dependencies.hiltAndroid)
    implementation(Dependencies.hiltCompose)
    kapt(Dependencies.hiltCompiler)
    kaptTest(Dependencies.hiltAndroidCompiler)
    testImplementation(Dependencies.hiltAndroidTesting)
    androidTestImplementation(Dependencies.hiltAndroidTesting)
    androidTestImplementation(Dependencies.hiltAndroidTesting)
}

fun DependencyHandler.addComposeDependencies() {
    implementation(Dependencies.ui)
    implementation(Dependencies.material3Compose)
    implementation(Dependencies.preview)
    implementation(Dependencies.runtime)
    implementation(Dependencies.foundation)
    implementation(Dependencies.materialIconCore)
    implementation(Dependencies.materialIconExtended)
    implementation(Dependencies.activity)
    implementation(Dependencies.viewModel)
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.lottie)
    implementation(Dependencies.paging)
    implementation(Dependencies.coil)
    implementation(Dependencies.swiperefresh)
    implementation(Dependencies.systemuicontroller)
    implementation(Dependencies.insets)
    implementation(Dependencies.placeholderMaterial)
    implementation(Dependencies.navigationMaterial)
    implementation(Dependencies.permissions)
    implementation(Dependencies.pager)
    implementation(Dependencies.indicators)
    implementation(Dependencies.webview)
    androidTestImplementation(Dependencies.testJunit4)
    debugImplementation(Dependencies.tooling)
    debugImplementation(Dependencies.testManifest)
}

fun DependencyHandler.addNavigationDependencies() {
    implementation(Dependencies.destinationAnimation)
    implementation(Dependencies.destinationCore)
    ksp(Dependencies.destinationKsp)
}

fun DependencyHandler.addTestDependencies() {
    implementation(Dependencies.junit)
}

fun DependencyHandler.addModuleDependencies() {
    SPLASH
    FRAMEWORK
}

val DependencyHandler.USE_CASE
    get() = implementation(project(mapOf("path" to Modules.domainUseCase)))

val DependencyHandler.CONSTANTS
    get() = implementation(project(mapOf("path" to Modules.coreConstants)))

val DependencyHandler.REPOSITORY
    get() = implementation(project(mapOf("path" to Modules.dataRepository)))

val DependencyHandler.FRAMEWORK
    get() = implementation(project(mapOf("path" to Modules.coreFramework)))

val DependencyHandler.SPLASH
    get() = implementation(project(mapOf("path" to Modules.presentationSplash)))

/**
 * Adds a dependency to the `releaseImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.releaseImplementation(dependencyNotation: Any): Dependency? =
    add("releaseImplementation", dependencyNotation)

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? =
    add("kaptTest", dependencyNotation)

fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? =
    add("kaptAndroidTest", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds a dependency to the `androidTestImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/**
 * Adds a dependency to the `ksp` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? =
    add("ksp", dependencyNotation)
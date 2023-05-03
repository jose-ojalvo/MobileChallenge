/**
 *   @author jojalvo
 *   @since 28/3/23
 *   @email josealejandro025@gmail.com
 */
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addCommonDependencies() {
    addCommonImplDependencies()
    addTestDependencies()
}

fun DependencyHandler.addCommonImplDependencies() {
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
    implementation(Dependencies.javaPoet)
}

fun DependencyHandler.addNetworkDependency() {
    implementation(Dependencies.moshi)
    ksp(Dependencies.moshiCodegen)
    implementation(Dependencies.moshiLazyAdapter)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitMoshi)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.loggingInterceptor)
    testImplementation(Dependencies.okhttp)
    debugImplementation(Dependencies.chuckerDebug)
    releaseImplementation(Dependencies.chuckerRelease)
}

fun DependencyHandler.addTestDependencies() {
    testImplementation(Dependencies.hamcrest)
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.robolectric)
    testImplementation(Dependencies.mockito)
    testImplementation(Dependencies.mockitoInline)
    testImplementation(Dependencies.androidTestCore)
    testImplementation(Dependencies.junitKotlin)
    testImplementation(Dependencies.archCoreTest)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.coroutinesTest)
    testImplementation(Dependencies.testTruth)
    testImplementation(Dependencies.testJunit4)
    testImplementation(Dependencies.testTurbine)
    androidTestImplementation(Dependencies.androidTestCore)
    androidTestImplementation(Dependencies.robolectric)
    androidTestImplementation(Dependencies.testExtJunit)
    androidTestImplementation(Dependencies.espressoCore)
    debugImplementation(Dependencies.fragmentTesting)
    debugImplementation(Dependencies.testManifest)
    debugImplementation("androidx.test:monitor:1.6.1")
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

fun DependencyHandler.addPreferenceDependencies() {
    implementation(Dependencies.datastore)
    implementation(Dependencies.datastorePref)
    implementation(Dependencies.securityPref)
}

fun DependencyHandler.addStorageDependencies() {
    implementation(Dependencies.roomKtx)
    ksp(Dependencies.roomCompiler)
}

fun DependencyHandler.addModuleDependencies() {
    COMPONENT
    CONSTANTS
    ENTITY
    FRAMEWORK
    HOME
    ONBOARDING
    PROVIDER
    REPOSITORY
    SETTINGS
    SPLASH
    TEST_UTILS
    THEME
    USERS
    USE_CASE
    UTILS
}

val DependencyHandler.COMPONENT
    get() = implementation(project(mapOf("path" to Modules.coreComponent)))

val DependencyHandler.CONSTANTS
    get() = implementation(project(mapOf("path" to Modules.coreConstants)))

val DependencyHandler.ENTITY
    get() = implementation(project(mapOf("path" to Modules.domainEntity)))

val DependencyHandler.FAVORITES
    get() = implementation(project(mapOf("path" to Modules.presentationFavorites)))

val DependencyHandler.FRAMEWORK
    get() = implementation(project(mapOf("path" to Modules.coreFramework)))

val DependencyHandler.HOME
    get() = implementation(project(mapOf("path" to Modules.presentationHome)))

val DependencyHandler.MODEL
    get() = implementation(project(mapOf("path" to Modules.dataModel)))

val DependencyHandler.LOCAL
    get() = implementation(project(mapOf("path" to Modules.dataLocal)))

val DependencyHandler.REMOTE
    get() = implementation(project(mapOf("path" to Modules.dataRemote)))

val DependencyHandler.ONBOARDING
    get() = implementation(project(mapOf("path" to Modules.presentationOnBoarding)))

val DependencyHandler.PROVIDER
    get() = implementation(project(mapOf("path" to Modules.coreProvider)))

val DependencyHandler.REPOSITORY
    get() = implementation(project(mapOf("path" to Modules.dataRepository)))

val DependencyHandler.SETTINGS
    get() = implementation(project(mapOf("path" to Modules.presentationSettings)))

val DependencyHandler.SPLASH
    get() = implementation(project(mapOf("path" to Modules.presentationSplash)))

val DependencyHandler.TEST_UTILS
    get() = implementation(project(mapOf("path" to Modules.coreTestUtils)))

val DependencyHandler.THEME
    get() = implementation(project(mapOf("path" to Modules.coreTheme)))

val DependencyHandler.USE_CASE
    get() = implementation(project(mapOf("path" to Modules.domainUseCase)))

val DependencyHandler.UTILS
    get() = implementation(project(mapOf("path" to Modules.coreUtils)))

val DependencyHandler.USERS
    get() = implementation(project(mapOf("path" to Modules.presentationUsers)))

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
/**
 *   @author jojalvo
 *   @since 27/3/23
 *   @email josealejandro025@gmail.com
 */
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

fun BaseAppModuleExtension.configBuildTypes() {
    buildTypes {
        getByName(BuildData.debug) {
            signingConfig = signingConfigs.getByName(BuildData.debug)
        }
        getByName(BuildData.release) {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile(BuildData.proguardTxt), BuildData.proguardPro
            )
            signingConfig = signingConfigs.getByName(BuildData.debug)
        }
    }
}
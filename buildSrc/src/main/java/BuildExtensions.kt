/**
 *   @author jojalvo
 *   @since 27/3/23
 *   @email josealejandro025@gmail.com
 */
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

fun BaseAppModuleExtension.configBuildTypes() {
    buildTypes {
        getByName(BuildData.debug) {
            buildConfigField("String","BASE_URL", VersionConfig.Debug.BaseUrl)
            buildConfigField("String","DB_NAME", VersionConfig.Debug.DbName)
            signingConfig = signingConfigs.getByName(BuildData.debug)
        }
        getByName(BuildData.release) {
            buildConfigField("String","BASE_URL", VersionConfig.Release.BaseUrl)
            buildConfigField("String","DB_NAME", VersionConfig.Release.DbName)
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
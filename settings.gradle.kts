pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
include(":app")
include(":presentation:splash")
include(":core")
include(":core:utils")
include(":core:framework")
include(":domain")
include(":domain:usecase")
include(":data")
include(":data:repository")
include(":core:constants")
include(":core:theme")
include(":presentation:onboarding")
include(":core:provider")
include(":core:testutils")
include(":presentation:home")
include(":core:component")
include(":presentation:settings")
include(":domain:entity")
include(":presentation:users")
include(":data:model")
include(":data:remote")
include(":data:local")

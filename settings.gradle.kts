enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    @Suppress("UnstableApiUsage") includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}


dependencyResolutionManagement {

    @Suppress("UnstableApiUsage") repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    @Suppress("UnstableApiUsage") repositories {
        maven(url = "https://androidx.dev/snapshots/builds/8455591/artifacts/repository") {
            content {
                includeGroupByRegex("androidx\\..*")
            }
        }
        google()
        mavenCentral()
    }
}
rootProject.name = "cmessenger"
include(":app")
include(":feature-auth")
include(":core-navigation")
include(":core-ui")
include(":utils-ui")

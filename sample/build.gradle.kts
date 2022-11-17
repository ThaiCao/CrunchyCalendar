import buildconfig.AppModuleBuildConfiguration

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    AppModuleBuildConfiguration(project, appExtension = this).configure()

    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.VERSION
    }
}

dependencies {
    coreLibraryDesugaring(Tools.DESUGAR_JDK_LIBS)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Core modules
    implementation(project(":crunchycalendar"))
    implementation(project(":crunchycalendarcompose"))
    implementation(KotlinLibs.STDLIB)
    implementation(AndroidX.APPCOMPAT)
    implementation(AndroidX.RECYCLER_VIEW)
    implementation(UI.VIEWBINDING_PROPERTY_DELEGATE)

    //Compose
    implementation(Compose.FOUNDATION)
    implementation(Compose.UI)
    implementation(Compose.ACTIVITY)
    implementation(Compose.MATERIAL_YOU)
    implementation(Compose.ANIMATIONS)
    implementation(Compose.RUNTIME)
    implementation(Compose.VIEWMODELS)
    implementation(Compose.TOOLING)
    implementation(Compose.CONSTRAINT)
}

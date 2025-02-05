plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.android.example"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.example.lint_usage"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    lint {
        checkReleaseBuilds = true
        checkAllWarnings = true
        checkDependencies = true
        // Produce report for CI:
        // https://docs.github.com/en/github/finding-security-vulnerabilities-and-errors-in-your-code/sarif-support-for-code-scanning
        sarifOutput = file("../lint-results.sarif")
        textReport = true
        textOutput = file("../stdout.txt")
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(files("libs/library-debug.aar"))
//    implementation(project(":library"))
//    lintChecks(project(":checks"))
}
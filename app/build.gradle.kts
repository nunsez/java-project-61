group = "hexlet.code"
version = "0.0.1"

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.jvm)

    // Kotlin linter
    alias(libs.plugins.detekt)

    // Apply the application plugin to add support for building a CLI application in Java.
    application

    checkstyle
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    // implementation(libs.guava)

    detektPlugins(libs.detekt.formatting)
}

// testing {
//     suites {
//         // Configure the built-in test suite
//         val test by getting(JvmTestSuite::class) {
//             // Use Kotlin Test test framework
//             useKotlinTest("1.9.23")
//         }
//     }
// }

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "$group.App"
}

detekt {
    // Version of detekt that will be used. When unspecified the latest detekt
    // version found will be used. Override to stay on the same version.
    // toolVersion = "1.23.6"

    // The directories where detekt looks for source files.
    // Defaults to `files("src/main/java", "src/test/java", "src/main/kotlin", "src/test/kotlin")`.
    // source.setFrom("src/main/java", "src/main/kotlin")

    // Builds the AST in parallel. Rules are always executed in parallel.
    // Can lead to speedups in larger projects. `false` by default.
    parallel = true

    // point to your custom config defining rules to run, overwriting default behavior
    config.setFrom("$projectDir/config/detekt.yml")

    // Applies the config files on top of detekt's default config file. `false` by default.
    buildUponDefaultConfig = false

    // Turns on all the rules. `false` by default.
    allRules = false

    // a way of suppressing issues before introducing detekt
    baseline = file("$projectDir/config/baseline.xml")

    // Disables all default detekt rulesets and will only run detekt with custom rules
    // defined in plugins passed in with `detektPlugins` configuration. `false` by default.
    disableDefaultRuleSets = false

    // Adds debug output during task execution. `false` by default.
    debug = false

    // If set to `true` the build does not fail when the
    // maxIssues count was reached. Defaults to `false`.
    ignoreFailures = false

    // Specify the base path for file paths in the formatted reports.
    // If not set, all file paths reported will be absolute file path.
    basePath = projectDir.absolutePath
}

tasks.register("removeDotGradle") {
    doLast {
        val dotGradleDir = File("$projectDir/.gradle")
        dotGradleDir.deleteRecursively()
    }
}

tasks.named("installDist") {
    dependsOn(":removeDotGradle")
}

tasks.withType<Checkstyle>() {
    exclude(".gradle/**")
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}

group = "hexlet.code"
version = "0.0.1"

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    // alias(libs.plugins.jvm)
    kotlin("jvm") version "1.9.23"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // This dependency is used by the application.
    // implementation(libs.guava)
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

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

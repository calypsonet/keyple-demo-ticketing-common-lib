import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

///////////////////////////////////////////////////////////////////////////////
//  GRADLE CONFIGURATION
///////////////////////////////////////////////////////////////////////////////
plugins {
    kotlin("jvm") version "1.7.0"
    id("com.diffplug.spotless") version "5.10.2"
}
buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.eclipse.keyple:keyple-gradle:0.2.+") { isChanging = true }
    }
}
apply(plugin = "org.eclipse.keyple")

///////////////////////////////////////////////////////////////////////////////
//  APP CONFIGURATION
///////////////////////////////////////////////////////////////////////////////
repositories {
    mavenLocal()
    mavenCentral()
}
dependencies {
    implementation("com.github.devnied:bit-lib4j:1.4.5") {
        exclude(group = "org.slf4j")
    }
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.15.0")
    testImplementation("com.github.devnied:bit-lib4j:1.4.5")
}

///////////////////////////////////////////////////////////////////////////////
//  TASKS CONFIGURATION
///////////////////////////////////////////////////////////////////////////////
tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    spotless {
        kotlin {
            target("**/*.kt")
            ktfmt()
            licenseHeaderFile("${project.rootDir}/LICENSE_HEADER")
        }
    }
    test {
        useJUnitPlatform()
    }
}
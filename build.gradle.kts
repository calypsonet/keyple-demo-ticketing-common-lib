import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

///////////////////////////////////////////////////////////////////////////////
//  GRADLE CONFIGURATION
///////////////////////////////////////////////////////////////////////////////
plugins {
    kotlin("jvm") version "1.7.0"
    id("com.diffplug.spotless") version "6.25.0"
}
buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    dependencies {
        classpath("org.eclipse.keyple:keyple-gradle:1.0.+") { isChanging = true }
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
    implementation("org.eclipse.keyple:keyple-util-java-lib:2.4.0")
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.15.0")
    testImplementation("com.github.devnied:bit-lib4j:1.4.5")
}
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
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
            licenseHeaderFile("${project.rootDir}/LICENSE_HEADER_BSD_3-CLAUSE")
        }
    }
    test {
        useJUnitPlatform()
    }
}
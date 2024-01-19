import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	val kotlinVersion = "1.9.0"
	val springBootVersion = "3.1.5"

	repositories {
		mavenCentral()
	}

	dependencies {
		classpath("io.spring.gradle:dependency-management-plugin:1.1.3")
		classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
		classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
	}
}

allprojects {
	group = "my.gayeon"
	version = "1.0-SNAPSHOT"
}

subprojects {
	repositories {
		mavenCentral()
	}

	apply(plugin = "java")
	apply(plugin = "org.jetbrains.kotlin.jvm")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
	apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
	apply(plugin = "org.springframework.boot")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}
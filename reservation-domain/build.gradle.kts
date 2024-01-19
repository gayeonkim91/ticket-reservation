dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    runtimeOnly("com.mysql:mysql-connector-j")

    implementation("org.flywaydb:flyway-core:10.5.0")
}

plugins {
    id("org.flywaydb.flyway") version "10.5.0"
}

tasks {
    bootJar {
        enabled = false
    }

    jar {
        enabled = true
    }
}
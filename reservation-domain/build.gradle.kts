
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

plugins {
    id("org.flywaydb.flyway") version "9.16.3"
}

flyway {
    url = "jdbc:mysql://localhost:3306/ticket_reservation?characterEncoding=UTF-8&serverTimezone=UTC"
    user = "gayeonkim"
    password = "1234"
}

tasks {
    bootJar {
        enabled = false
    }

    jar {
        enabled = true
    }
}
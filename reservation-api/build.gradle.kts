dependencies {
    implementation(project(":reservation-domain"))
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
}

tasks {
    jar {
        enabled = false
    }

    bootJar {
        enabled = true
    }
}
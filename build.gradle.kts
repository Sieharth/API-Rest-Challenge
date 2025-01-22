plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.forohub"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Core
    implementation("org.springframework.boot:spring-boot-starter")

    // Spring Web para construir la API REST
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Data JPA para la base de datos
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // H2 Database para pruebas iniciales
    runtimeOnly("com.h2database:h2")

    // Spring Security para autenticación y autorización
    implementation("org.springframework.boot:spring-boot-starter-security")

    // Para pruebas
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

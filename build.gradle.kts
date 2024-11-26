plugins {
    war
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.openrewrite.rewrite") version ("6.27.1")
}

group = "br.com.coffeefinder"
version = "0.0.1-SNAPSHOT"
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.data:spring-data-commons:3.4.0")

    runtimeOnly("org.postgresql:postgresql")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2:2.3.232")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

rewrite {
    activeRecipe("org.openrewrite.java.format.AutoFormat")
}
tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register("bootRunDev") {
    group = "application"
    description = "Runs the Spring Boot application with the dev profile"
    doFirst {
        tasks.bootRun.configure {
            systemProperty("spring.profiles.active", "dev")
        }
    }
    finalizedBy("bootRun")
}

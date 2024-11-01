plugins {
    war
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    id("org.openrewrite.rewrite") version "6.26.0"
}

group = "br.com.coffeefinder"
version = "0.0.1-SNAPSHOT"
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
rewrite {
    activeRecipe("com.yourorg.SayHelloToFooBar")
    activeStyle("org.openrewrite.java.SpringFormat")
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
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.data:spring-data-jpa:3.3.5")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("jakarta.persistence:jakarta.persistence-api:3.2.0")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    rewrite("org.openrewrite.recipe:rewrite-static-analysis:latest-release")
    rewrite("org.openrewrite.recipe:rewrite-java-security:2.14.1")
    rewrite("org.openrewrite.recipe:rewrite-spring:5.22.0")
    rewrite("org.openrewrite.recipe:rewrite-testing-frameworks:2.21.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

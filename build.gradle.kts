import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.30"
    val springBootVersion = "2.1.4.RELEASE"

    application
    idea

    id("org.springframework.boot") version springBootVersion

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion

    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

group = "nz.zoltan"
version = "0.0.1-SNAPSHOT"

application {
    mainClassName = "nz.zoltan.springmongo.SpringMongoApplication"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")


    // Add handy developer tools support like livereload and auto rebuild
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {

        // Turn off JUnit v4 and add v5 below
        exclude(module = "juni")

        // Turn off mockito because of Kotlin friendly Spring Mockk
        exclude(module = "mockito-core")
    }

    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
    testImplementation("io.projectreactor:reactor-test")

    // Add JUnit v5
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // Add Spring Mockk https://github.com/Ninja-Squad/springmockk
    testImplementation("com.ninja-squad:springmockk:1.1.2")
}

tasks.withType<KotlinCompile> {


    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {

    // This adds JUnit v5 support
    useJUnitPlatform()
}

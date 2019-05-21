import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.liquibase.gradle.LiquibaseExtension
import java.util.*
import java.io.*

plugins {
    kotlin("jvm") version "1.3.31"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.31"
    id("org.springframework.boot") version "2.1.4.RELEASE"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.31"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    id("org.liquibase.gradle") version "2.0.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

configurations {
    compileOnly {
        extendsFrom(configurations["annotationProcessor"])
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform({
        includeEngines("spek2")
    })
}

repositories {
    mavenCentral()
    jcenter()
}

ext {
    set("springBootAdminVersion", "2.1.4")
    set("springCloudVersion", "Greenwich.SR1")
}

dependencies {
    // kotlin dependencies
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // liquibase dependencies
    liquibaseRuntime("org.liquibase:liquibase-core")
    liquibaseRuntime("org.postgresql:postgresql")
    liquibaseRuntime("ch.qos.logback:logback-core:1.2.3")
    liquibaseRuntime("ch.qos.logback:logback-classic:1.2.3")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")



    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

//    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.boot:spring-boot-starter-cache")
//    implementation("org.springframework.boot:spring-boot-starter-data-cassandra")

//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
//    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
//    implementation("org.springframework.boot:spring-boot-starter-integration")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
//    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("de.codecentric:spring-boot-admin-starter-server")
//    implementation("org.apache.kafka:kafka-streams")
//    implementation("org.liquibase:liquibase-core")
//    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.0.1")
//    implementation("org.springframework.cloud:spring-cloud-starter-aws")
//    implementation("org.springframework.cloud:spring-cloud-starter-aws-jdbc")
//    implementation("org.springframework.cloud:spring-cloud-starter-aws-messaging")
//    implementation("org.springframework.data:spring-data-rest-hal-browser")
    implementation("org.springframework.kafka:spring-kafka")
//    implementation("org.springframework.session:spring-session-data-redis")
//    implementation("org.springframework.session:spring-session-jdbc")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("io.mockk:mockk:1.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    // spek 2
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.4")
    testImplementation("org.spekframework.spek2:spek-runner-junit5:2.0.4")
    testImplementation("org.amshove.kluent:kluent:1.49")
}

dependencyManagement {
    val springCloudVersion = "Finchley.SR2"
    val springBootAdminVersion = "2.1.4"
    imports {
        mavenBom("de.codecentric:spring-boot-admin-dependencies:$springBootAdminVersion")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

/**
 * Liquibase plugin assumes that 'liquibase.properties' file has been created in the root directory.  See 'liquibase.example.properties'
 * for an example.
 */
liquibase {
    activities.register("main") {}
    runList = "main"
}

sourceSets["main"].java.srcDir("src/main/kotlin")
sourceSets["main"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir("src/main/kotlin")
}
sourceSets["test"].java.srcDir("src/main/kotlin")
sourceSets["test"].withConvention(KotlinSourceSet::class) {
    kotlin.srcDir("src/test/kotlin")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "12"
    }
}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.3.31"
    id("org.springframework.boot") version "2.1.4.RELEASE"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.31"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
//sourceCompatibility = "1.8"

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
//    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.boot:spring-boot-starter-cache")
//    implementation("org.springframework.boot:spring-boot-starter-data-cassandra")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis")
//    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
//    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
//    implementation("org.springframework.boot:spring-boot-starter-integration")
//    implementation("org.springframework.boot:spring-boot-starter-jdbc")
//    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("de.codecentric:spring-boot-admin-starter-server")
//    implementation("org.apache.kafka:kafka-streams")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.liquibase:liquibase-core")
//    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.0.1")
//    implementation("org.springframework.cloud:spring-cloud-starter-aws")
//    implementation("org.springframework.cloud:spring-cloud-starter-aws-jdbc")
//    implementation("org.springframework.cloud:spring-cloud-starter-aws-messaging")
//    implementation("org.springframework.data:spring-data-rest-hal-browser")
    implementation("org.springframework.kafka:spring-kafka")
//    implementation("org.springframework.session:spring-session-data-redis")
//    implementation("org.springframework.session:spring-session-jdbc")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
//    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("io.mockk:mockk:1.9.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-api:5.1.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")
    // spek 1
//    testImplementation("org.jetbrains.spek:spek-api:1.1.5")
//    testImplementation("org.jetbrains.spek:spek-junit-platform-engine:1.1.5")
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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.7"

    //스프링부트 의존성 관리
    id("io.spring.dependency-management") version "1.1.0"

    //kotlin fianl class 전부 open 으로 변경
    kotlin("plugin.allopen") version "1.8.21"

    //kotlin 에서 annotation processor 를 사용 가능하게해주는 플러그인
    kotlin("kapt") version "1.8.21"

    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
}

allprojects {
    group = "com.example"

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.3")
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
    }
}

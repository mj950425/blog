// normal jar
tasks.getByName<Jar>("jar") {
    enabled = false
}

// spring boot jar
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = true
}

dependencies {
    //project
    implementation(project(":infra-client"))
    implementation(project(":infra-persistence"))
    implementation(project(":domain"))
    implementation(project(":common"))

    implementation("org.springframework:spring-tx")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.data:spring-data-commons")

    // thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

}

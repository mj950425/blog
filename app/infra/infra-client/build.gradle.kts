dependencies {
    //feign client
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.0.3")

    implementation(project(":domain"))
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

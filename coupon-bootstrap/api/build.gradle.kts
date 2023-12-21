dependencies {
    implementation(project(":kafka"))
    implementation(project(":redis"))
    implementation(project(":coupon-usecase"))
    implementation(project(":coupon-domain"))

    implementation("org.springframework.boot:spring-boot-starter-web:${Version.SPRING_BOOT}")
    developmentOnly("org.springframework.boot:spring-boot-devtools:${Version.SPRING_BOOT}")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose:${Version.SPRING_BOOT}")

    testImplementation("org.testcontainers:testcontainers:1.19.3")
    testImplementation("org.testcontainers:junit-jupiter:1.19.3")
    testImplementation("io.kotest.extensions:kotest-extensions-testcontainers:2.0.2")
}

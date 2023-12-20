dependencies {
    implementation(project(":coupon-domain"))
    implementation(project(":coupon-usecase"))
    implementation(project(":persistence"))

    implementation("org.springframework.boot:spring-boot-starter-web:${Version.SPRING_BOOT}")
    implementation("org.springframework.kafka:spring-kafka:${Version.SPRING_KAFKA}")

    developmentOnly("org.springframework.boot:spring-boot-devtools:${Version.SPRING_BOOT}")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose:${Version.SPRING_BOOT}")
}

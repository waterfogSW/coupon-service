dependencies {
    implementation(project(":kafka"))
    implementation(project(":redis"))
    implementation(project(":coupon-usecase"))
    implementation(project(":coupon-domain"))

    implementation("org.springframework.boot:spring-boot-starter-web:${Version.SPRING_BOOT}")
    developmentOnly("org.springframework.boot:spring-boot-devtools:${Version.SPRING_BOOT}")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose:${Version.SPRING_BOOT}")
}

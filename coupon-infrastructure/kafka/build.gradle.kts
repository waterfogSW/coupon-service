import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":coupon-domain"))
    implementation(project(":coupon-usecase"))

    implementation("org.springframework.boot:spring-boot:${Version.SPRING_BOOT}")
    implementation("org.springframework.kafka:spring-kafka:${Version.SPRING_KAFKA}")
}

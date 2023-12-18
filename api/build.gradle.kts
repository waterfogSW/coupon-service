import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:${Version.SPRING_BOOT}")

    // redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis:${Version.SPRING_BOOT}")

    // kafka
    implementation("org.springframework.kafka:spring-kafka:3.1.0")

    // devtools
    developmentOnly("org.springframework.boot:spring-boot-devtools:${Version.SPRING_BOOT}")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose:${Version.SPRING_BOOT}")

    // mysql
    runtimeOnly("com.mysql:mysql-connector-j:8.0.32")

    // test database
    testImplementation("com.h2database:h2:2.1.214")

}

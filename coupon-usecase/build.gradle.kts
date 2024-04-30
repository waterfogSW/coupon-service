import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":ulid"))
    implementation(project(":coupon-domain"))

    implementation(libs.spring.boot.core)
}

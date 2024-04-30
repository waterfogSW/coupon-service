dependencies {
    implementation(project(":kafka"))
    implementation(project(":redis"))
    implementation(project(":coupon-usecase"))
    implementation(project(":coupon-domain"))

    implementation(libs.spring.boot.starter.web)
    developmentOnly(libs.spring.boot.devtools)
    developmentOnly(libs.spring.boot.docker.compose)
    testImplementation(libs.testcontainers)
    testImplementation(libs.testcontainers.junit.jupiter)
    testImplementation(libs.kotest.extensions.testcontainers)
}

dependencies {
    implementation(project(":coupon-domain"))
    implementation(project(":coupon-usecase"))
    implementation(project(":persistence"))

    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.kafka)
    developmentOnly(libs.spring.boot.devtools)
    developmentOnly(libs.spring.boot.docker.compose)
}

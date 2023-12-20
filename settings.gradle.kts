pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "coupon-service"
include("api")

// common
include(":ulid")
project(":ulid").projectDir = file("./coupon-common/ulid")

// domain
include("coupon-domain")

// usecase
include("coupon-usecase")

// infrastructures
include(":redis")
project(":redis").projectDir = file("./coupon-infrastructure/redis")

include(":persistence")
project(":persistence").projectDir = file("./coupon-infrastructure/persistence")

include(":kafka")
project(":kafka").projectDir = file("./coupon-infrastructure/kafka")

// bootstraps
include(":api")
project(":api").projectDir = file("./coupon-bootstrap/api")

include(":worker")
project(":worker").projectDir = file("./coupon-bootstrap/worker")

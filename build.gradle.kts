plugins {
    kotlin("jvm") version "1.9.23"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(21)
}

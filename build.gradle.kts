plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "com.tariq"
version = "1.0-SNAPSHOT"

application{
    mainClass.set("io.ktor.server.netty.EngineMain")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-server-core:2.3.0")
    implementation("io.ktor:ktor-server-netty:2.3.0")
    implementation("ch.qos.logback:logback-classic:1.2.5")
    implementation("io.ktor:ktor-server-call-logging:2.3.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}
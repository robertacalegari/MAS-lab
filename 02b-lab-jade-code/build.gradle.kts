plugins {
    // Apply the java plugin to add support for Java
    java
}

val platformName: String by project
val platformHost: String by project
val containerBaseName: String by project

repositories {
    mavenCentral()
//    maven("https://jade.tilab.com/maven/") // Stale certificates
}

dependencies {
//    implementation("com.tilab.jade:jade:4.5.0")
    implementation(fileTree("libs").also { it.include("**/*.jar") })
    testImplementation("junit:junit:4.13")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
}

tasks.create<JavaExec>("startPlatform") {
    main = "jade.Boot"
    group = "run"
    sourceSets.main {
        classpath = runtimeClasspath
    }
    args("-gui", "-name", platformName, "-container-name", containerBaseName + "main", "-local-host", platformHost)
}

tasks.create<JavaExec>("startContainer") {
    main = "jade.Boot"
    group = "run"
    sourceSets.main {
        classpath = runtimeClasspath
    }
    args("-container", "-container-name", containerBaseName + System.currentTimeMillis(), "-host", platformHost)
    if (project.hasProperty("agents")) {
        val agents = project.property("agents").toString()
        if (agents.isNotBlank()) {
            args("-agents", agents)
        }
    }
}
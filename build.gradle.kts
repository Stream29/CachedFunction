import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm") version "2.0.0"
    id("com.vanniktech.maven.publish") version "0.29.0"
}

group = "io.github.stream29"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

mavenPublishing {
    configure(JavaLibrary(
        JavadocJar.Javadoc(),
        true
    ))
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
    coordinates((group as String), "cached-function", version.toString())
    pom {
        name.set("Cached functions")
        description.set("A description of what my library does.")
        inceptionYear.set("2020")
        url.set("https://github.com/Stream29/CachedFunction")
        licenses {
            license {
                name.set("GNU General Public License Version 3")
                url.set("https://www.gnu.org/licenses/gpl-3.0.html")
                distribution.set("https://www.gnu.org/licenses/gpl-3.0.html")
            }
        }
        developers {
            developer {
                id.set("Stream29")
                name.set("Stream")
                url.set("https://github.com/Stream29/")
            }
        }
        scm {
            url.set("https://github.com/Stream29/CachedFunction")
            connection.set("scm:git:git://github.com/Stream29/CachedFunction.git")
            developerConnection.set("scm:git:ssh://git@github.com:Stream29/CachedFunction.git")
        }
    }
}
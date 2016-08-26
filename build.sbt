import com.typesafe.sbt.SbtNativePackager.autoImport._
import com.typesafe.sbt.packager.linux.LinuxPlugin.autoImport._
import com.typesafe.sbt.packager.rpm.RpmPlugin.autoImport._

name := "scala-tutorial"

version := "1.0"

scalaVersion := "2.11.7"

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo <<= version { v: String =>
  val nexus = "http://nexus.noggin.space:8081/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "repository/maven-snapshots")
  else
    Some("releases" at nexus + "repository/maven-releases")
}
val slickV = "3.1.0"
val sprayV = "1.3.3"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
  "org.slf4j" % "slf4j-api" % "1.7.12",
  "org.slf4j" % "slf4j-simple" % "1.7.12" % "runtime,optional",
  "com.ning" % "async-http-client" % "1.9.21",
  "io.jsonwebtoken" % "jjwt" % "0.6.0",
  "org.specs2" %% "specs2-core" % "3.6.6" % "test",
  "com.typesafe" % "config" % "1.3.0",
  "me.moocar" % "logback-gelf" % "0.3",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)

resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "rediscala" at "http://dl.bintray.com/etaty/maven",
  "Maven Repository RedMart" at "https://github.com/Redmart/maven-repo/raw/master/",
  "maven-repo" at "https://github.com/Redmart/maven-repo/raw/master/",
  "Noggin Nexus" at "http://nexus.noggin.space:8081/repository/maven-public/"
)
lazy val ikognitoMonitoringReader = (project in file("."))
  .enablePlugins(JavaServerAppPackaging, RpmPlugin, RpmDeployPlugin)

mainClass in(Compile, run) := Some("Solution")

packageName in Rpm := "ikognito-monitoring-reader"
version in Rpm := "1.0.0"
maintainer in Rpm := "Noggin Support <support@nogginasia.com>"
packageSummary in Rpm := "This package installs ikognito-monitoring-reader"
packageDescription in Rpm :=
  """Reader of greenfield metrics""".stripMargin

serverLoading in Rpm := com.typesafe.sbt.packager.archetypes.ServerLoader.SystemV

rpmVendor := "NogginAsia"
rpmUrl := Some("http://www.nogginasia.com")
rpmLicense := Some("Proprietary License")
rpmRelease := "1"
exportJars := true
defaultLinuxInstallLocation := "/Users/luongbalinh/Desktop"
daemonUser in Linux := normalizedName.value
daemonGroup in Linux := (daemonUser in Linux).value

javaOptions in Universal ++= Seq(
  // Since play uses separate pidfile we have to provide it with a proper path
  s"-Dpidfile.path=/var/run/${packageName.value}/play.pid",

  s"-Dconfig.file=/opt/${packageName.value}/conf/application.conf",

  s"-Dlogger.file=/opt/${packageName.value}/conf/logback.xml"
)

publishArtifact in (Compile, packageDoc) := false

publishArtifact in (Compile, packageSrc) := false

publishArtifact in (Compile, packageConfiguration) := false


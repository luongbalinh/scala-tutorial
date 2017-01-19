name := "scala-tutorial"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.8",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.8",
  "com.chuusai" %% "shapeless" % "2.3.2",
  "io.reactivex" %% "rxscala" % "0.26.4",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
)

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

scalacOptions ++= Seq(
  "-Ywarn-value-discard"
)

javaOptions := Seq("-Xmx1G",
  "- XX:+UnlockCommercialFeatures",
  "-XX:+FlightRecorder",
  "- XX:+UnlockDiagnosticVMOptions",
  "-XX:+DebugNonSafepoints",
  "- XX:FlightRecorderOptions=defaultrecording=true,dumponexit=true,dumponexitpath=/tmp/order-book.jfr"
)
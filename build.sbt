

name := """scala-tutorial"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "com.etaty.rediscala" %% "rediscala" % "1.5.0",
  "com.redmart.micro-service-dto" % "member-service-dto" % "1.0",
  "com.typesafe.play" % "play-json_2.11" % "2.4.3",
  "org.scala-lang.modules" %% "scala-pickling" % "0.10.1",
  "com.github.kstyrc" % "embedded-redis" % "0.6",
  "org.apache.commons" % "commons-lang3" % "3.4"

)


resolvers ++= Seq(
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "rediscala" at "http://dl.bintray.com/etaty/maven",
  "Maven Repository RedMart" at "https://github.com/Redmart/maven-repo/raw/master/",
  "maven-repo" at "https://github.com/Redmart/maven-repo/raw/master/"
)


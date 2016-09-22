name := """backend-play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.codehaus.jackson" % "jackson-core-asl" % "1.9.13",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.3.4",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.3.0",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.2",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

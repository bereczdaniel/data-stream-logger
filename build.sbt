name := "data-stream-logger"

version := "0.1"

scalaVersion := "2.11.7"

lazy val flinkVersion = "1.7.1"

lazy val flinkDependencies = Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion,
  "org.apache.flink" %% "flink-streaming-java" % flinkVersion,
  "org.apache.flink" %% "flink-test-utils" % flinkVersion
)

lazy val flinkKafkaDependencies = Seq(
  "org.apache.flink" % "flink-connector-kafka-0.11_2.11" % flinkVersion
)

lazy val couchbaseDependencies = Seq(
  "com.couchbase.client" % "java-client" % "2.7.2"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    libraryDependencies ++= flinkDependencies.map(_ % "provided"),
    libraryDependencies ++= flinkKafkaDependencies,
    libraryDependencies ++= couchbaseDependencies
  )

lazy val commonSettings = Seq(
  organization := "hu.sztaki.ilab",
  version := "0.1",
  scalaVersion := "2.11.7"
)
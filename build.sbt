name := "spark-livy-poc"

version := "0.1"

scalaVersion := "2.11.8"
val sparkVersion = "2.2.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
  "org.apache.spark" %% "spark-sql" % sparkVersion % Provided
)

libraryDependencies += "com.cloudera.livy" % "livy-client-http" % "0.3.0"

resolvers += "Cloudera Repositories" at "https://repository.cloudera.com/artifactory/cloudera-repos"
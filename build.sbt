name := "scala-with-cats-ex"

version := "0.1"

scalaVersion := "2.12.8"

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification"
)

libraryDependencies += "org.typelevel" %% "cats-core" % "1.5.0"

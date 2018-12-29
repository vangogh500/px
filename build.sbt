name := "px"
organization := "com.github.vangogh500"

enablePlugins(ScalaJSPlugin)
scalaJSModuleKind := ModuleKind.CommonJSModule

libraryDependencies ++= {
  val scala_test = "3.0.5"
  Seq(
    "org.scalatest" %%% "scalatest" % scala_test % "test"
  )
}

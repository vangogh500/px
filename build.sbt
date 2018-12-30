name := "px"
organization := "com.github.vangogh500"

enablePlugins(ScalaJSPlugin)
scalaJSModuleKind := ModuleKind.CommonJSModule

libraryDependencies ++= {
  val scala_test = "3.0.5"
  val akka_js = "1.2.5.19"
  Seq(
    "org.akka-js" %%% "akkajsactor" % akka_js % "provided",
    "org.akka-js" %%% "akkajstestkit" % akka_js % "test",
    "org.scalatest" %%% "scalatest" % scala_test % "test"
  )
}

package patternmatching

object MyPatternMatching extends App {
  simpleMatching

  def simpleMatching = {
    for {
      x <- Seq(1, 2, 2.7, "one", "two", 'four)
    } {
      val str = x match {
        case _: Int | _: Double => "a number: " + x
        case "one" => "string one"
        case _: String => "other string: " + x
        case _ => "unexpected value: " + x
      }
      println(str)
    }
  }

  // use pattern martching in value definition
  def createPersonInfo(): (String, Int) = ("Linh", 20)
  val (name, _) =  createPersonInfo()
  println(s"name $name")

}




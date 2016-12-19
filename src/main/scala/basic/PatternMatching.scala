package basic

object PatternMatching extends App {
  val result1 = Seq(1, 2, 2.7, "one", "two", 'four) map {
    case x: Int => "int: " + x
    case x: Double => "double: " + x
    case "one" => "string one"
    case x: String => "other string: " + x
    case x => "unexpected value: " + x
  }

  // value definition
  val (result2, _) = ("Value", 20)

  // regex
  val regex =
    """\((.+)\)\[([0-9]+)\]""".r
  val result3 = "(ab)[1];(cde)[11]".split(";") map {
    case regex(word, value) => (word, value.toInt)
  }

  println("debug point")
}




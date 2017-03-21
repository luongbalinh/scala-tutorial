package basic

// https://www.tutorialspoint.com/scala/scala_regular_expressions.htm
object RegularExpression extends App {

  val pattern1 = "(S|s)cala".r
  val str = "Scala is scalable and cool"
  val result1 = pattern1 replaceFirstIn(str, "Java")
  val result2 = pattern1 replaceAllIn(str, "Java")

  val pattern2 = "([0-9]+) ([A-Za-z]+)".r
  "100 Bananas" match {
    case pattern2(count, fruit) => println(count)
    case _ => "error in parsing"
  }
}

package collection

object FlatMap {
  def main(args: Array[String]) {


    // flatten treats a string as a sequence of characters
    val fruits = Seq("apple", "banana")
    println(fruits.flatMap(_.toUpperCase))

    // flatten ignores None
    val bag = List("1", "2", "three", "4", "one hundred seventy five")
    println(bag.flatMap(toInt).sum)

  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }
}

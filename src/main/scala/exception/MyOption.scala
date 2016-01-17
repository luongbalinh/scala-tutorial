package exception

// http://blog.xebia.com/2015/02/18/try-option-or-either/
object MyOption extends App {

  // Option is used to convert a partial function into a total function.
  def mean(numbers: Seq[Double]): Option[Double] = {
    if (numbers.isEmpty) None
    else Some(numbers.sum / numbers.length)
  }

  // Return an Option from a method
  def stringToInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s))
    } catch {
      case e: Exception => None
    }
  }

  /**
    * Option[A] is a container for a value of type A, hence can foreach, map, flatMap, filter, and for comprehension.
    * None values will be ignored.
    * Option[Option[T]] flatMap becomes Option[T]
    */
  stringToInt("10").foreach { i => println(i) }
  stringToInt("10") match {
    case Some(i) => println(i)
    case None => println("invalid input")
  }

}

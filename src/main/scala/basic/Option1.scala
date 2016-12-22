package basic

// http://blog.xebia.com/2015/02/18/try-option-or-either/
object Option1 extends App {

  // Option is used to convert a partial function into a total function.
  def mean(numbers: Seq[Double]): Option[Double] = {
    if (numbers.isEmpty) None
    else Some(numbers.sum / numbers.length)
  }

  /**
    * Handle exception. However, Option can only tell 1 error reason which is only defined in the the method's logic.
    *
    * For 2 error reasons, use Try or scalaz (http://typelevel.org/blog/2014/02/21/error-handling.html)
    */
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
  Option("A") foreach { i => println(i) }
}

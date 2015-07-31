package exception

// http://blog.xebia.com/2015/02/18/try-option-or-either/
object MyOption {
  def main(args: Array[String]) {
    args foreach (arg => countLines(arg))

  }

  // Option is used to convert a partial function into a total function.
  def mean(numbers: Seq[Double]): Option[Double] = {
    if (numbers.isEmpty) None
    else Some(numbers.sum / numbers.length)
  }

  /**
   * Return an Option from a method
   */

  def stringToInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s))
    } catch {
      case e: Exception => None
    }
  }

  /**
   * Get the value from an Option: (1) getOrElse, (2) foreach, and (3) match
   */
  stringToInt("10").getOrElse(0)
  stringToInt("10").foreach { i => println(i) }
  stringToInt("10") match {
    case Some(i) => println(i)
    case None => println("invalid input")
  }

  /**
   * Option with collection
   */

  def countLines(fileName: String) = {
    import scala.io.Source
    import scala.util.control.NonFatal

    var source: Option[Source] = None
    try {
      source = Some(Source.fromFile(fileName))
      val size = source.get.getLines.size
      println(s"file $fileName has $size lines")
    } catch {
      case NonFatal(ex) => println(s"Non fatal exception! $ex")
    } finally {
      for (s <- source) {
        println(s"Closing $fileName...")
        s.close
      }
    }
  }
}

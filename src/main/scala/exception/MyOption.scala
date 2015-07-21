package exception

object MyOption {
  def main(args: Array[String]) {
    args foreach (arg => countLines(arg))

  }

  // Option is used to convert a partial function into a total function.
  // In this example, when the list is empty, None will be returned.
  def mean(numbers: Seq[Double]): Option[Double] = {
    if (numbers.isEmpty) None
    else Some(numbers.sum / numbers.length)
  }

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

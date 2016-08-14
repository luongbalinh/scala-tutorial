import java.io.PrintWriter

import scala.io.Source

object FileHelper {
  def readInt()(implicit file: String): Int = {
    val lines = Source.fromFile(file).getLines().toList
    val afterRemoved = lines diff List(lines.head)
    val writer = new PrintWriter(file)
    if (afterRemoved.nonEmpty) {
      writer.write(afterRemoved.reduce(_ + "\n" + _))
      writer.flush()
      writer.close()
    }
    lines.head.toInt
  }

  def readLine()(implicit file: String): String = {
    val lines = Source.fromFile(file).getLines().toList
    val afterRemoved = lines diff List(lines.head)

    if (afterRemoved.nonEmpty) {
      val writer = new PrintWriter(file)
      writer.write(afterRemoved.reduce(_ + "\n" + _))
      writer.flush()
      writer.close()
    }
    lines.head
  }
}

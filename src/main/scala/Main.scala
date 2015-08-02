import scala.util.Try

object Main {
  def main(args: Array[String]) {
    val result = Try("1".toInt)
    val output = result.getOrElse(-1)
    println(output)
  }
}

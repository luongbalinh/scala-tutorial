import math.Rational

object Main {
  def main(args: Array[String]) {
    val r1 = new Rational(1, 3)
    val r2 = new Rational(2, 4)
    val add = r1 + r2
    println(s"$r1 + $r2 = $add")
  }
}

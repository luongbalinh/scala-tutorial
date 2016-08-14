package math

object Rational extends App {
  val r1 = new Rational(1, 3)
  val r2 = new Rational(2, 4)
  val add = r1 + r2
  println(s"$r1 + $r2 = $add")
}

/**
  * This class represents a rational number.
  *
  * @param n the numerator
  * @param d the denominator
  */
class Rational(n: Int, d: Int) {

  require(d != 0, "Error! Denominator is zero.")

  override def toString: String = {
    n + "/" + d
  }

  private val g = gcd(n, d)
  val numer: Int = n / g
  val denom: Int = d / g

  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def -(that: Rational) =
    new Rational(numer * that.denom - that.numer * denom,
      denom * that.denom)

  def *(that: Rational) =
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational) =
    new Rational(numer * that.denom, denom * that.numer)

  /**
    * Calculates the greatest common divisor of two integers.
    */
  private def gcd(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) gcd(-x, y)
    else if (y < 0) -gcd(x, -y)
    else gcd(y % x, x)
  }
}
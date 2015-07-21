package math

/**
 * This class represents a rational number.
 *
 * @param n the numerator
 * @param d the denominator
 */
class Rational(n: Int, d: Int) {

  require(d != 0, "Error! Denominator is zero.")

  override def toString(): String = {
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
   *
   * @param x
   * @param y
   * @return the greatest common divisor
   */
  private def gcd(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) gcd(-x, y)
    else if (y < 0) -gcd(x, -y)
    else gcd(y % x, x)
  }
}
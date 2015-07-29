package oo

object CaseClass {
  def main(args: Array[String]) {

  }

}

/**
 * Case classes come with a supplied implementation of equals and hashCode. The equivalence relation must have the
 * following properties:
 *
 * For all x; x equals x is true (reflexive)
 * For x, y, z; if x equals y and y equals z then x equals z (transitive)
 * For x, y; if x equals y then y equals x (symmetric)
 *
 * Never use case class inheritance
 *
 * case class Point(x: Int, y: Int)
 * case class ColoredPoint(override val x: Int, override val y: Int, c: Int) extends Point(x, y)
 *
 * Point(0, 0) equals ColoredPoint(0, 0, 000000) but not ColoredPoint(0, 0, 000000) equals Point(0, 0)
 *
 */



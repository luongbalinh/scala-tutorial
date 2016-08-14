package oo

import scala.collection.immutable.HashMap

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

/**
 * By default, Scala uses object location equality and hashing. Object location equality is using the address in
 * memory for an object as the only factor to determine if two objects are equal.
 */
object Equals {
  def main(args: Array[String]) {

    val pointX = new Point2(1, 1)
    val pointY = new Point2(2, 1)
    val pointZ = new Point2(4, 4)
    val map = HashMap(pointX -> "X", pointY -> "Y")

    println(s"Map before: $map")
    pointX.move(3, 3)
    println(s"Map after: $map")
    println(pointX == pointZ)
    println(map(pointX))
    println(map(pointZ))

  }

}

class Point2(var x: Int, var y: Int) extends Equals {
  def move(mx: Int, my: Int): Unit = {
    x = x + mx
    y = y + my
  }

  override def hashCode(): Int = y + (31 * x)

  def canEqual(that: Any): Boolean = that match {
    case p: Point2 => true
    case _ => false
  }

  override def equals(that: Any): Boolean = {
    def strictEquals(other: Point2) =
      this.x == other.x && this.y == other.y
    that match {
      case a: AnyRef if this eq a => true
      case p: Point2 => (p canEqual this) && strictEquals(p)
      case _ => false
    }
  }
}



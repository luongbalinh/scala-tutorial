package oo.overriding

/**
 * Cannot override `final` members
 *
 * When overriding a concrete member, Scala requires the override keyword. Avoid overriding concrete members.
 *
 * Never use `override` for abstract member since this member may be implemented in the future, and subclasses will
 * not know about the changes, i.e. compiler assumes that subclasses now truly override that member.
 */
object Override {
  def main(args: Array[String]) {
    val c = new ClassWithC1()
    println(c.name)
    println(c.count)

    val ac = new ClassWithAbstractC1()
    println(ac.name)
    println(ac.count)
  }

}

class C1 {
  val name = "C1"
  var count = 0
}

class ClassWithC1 extends C1 {
  override val name = "ClassWithC1"
  count = 1
}

/**
 * `override` is not required for abstract class.
 */
abstract class AbstractC1 {
  val name: String
  var count: Int
}

class ClassWithAbstractC1 extends AbstractC1 {
  val name = "ClassWithAbstractC1"
  var count = 1
}

abstract class Widget {
  def draw(): Unit

  override def toString() = "(widget)"
}

class Button(val label: String) extends Widget {
  // Simple hack for demonstration purposes:
  def draw(): Unit = println(s"Drawing: $this")

  // super.toString will find the “closest” parent type toString
  override def toString() = s"(button: label=$label, ${super.toString()})"
}
package typesystem

object PathDependentType extends App {
  val s1 = new Service
  val s2 = new Service {
    override val logger = s1.logger // ERROR
  }
}

class Service {

  class Logger {
    def log(message: String): Unit = println(s"log: $message")
  }

  val logger: Logger = new Logger
}

/**
  * Inside a type body, but outside a method definition, `this` refers to the type itself.
  */
trait T1 {

  class C

  val c1: C = new C
  val c2: C = new this.C // this.C refers to the trait T1
}

trait X {
  def setXX(x: String): Unit = {}
}

class C1 {
  var x = "1"

  // `this` refers to the current instance.
  def setX1(x: String): Unit = this.x = x

  def setX2(x: String): Unit = C1.this.x = x
}

class C2 extends C1

class C3 extends C2 with X {
  def setX3(x: String): Unit = super.setX1(x)

  def setX4(x: String): Unit = C3.super.setX1(x) // C3.super is equivalent to super

  //qualify which parent using [T]

  def setX5(x: String): Unit = C3.super[C2].setX1(x)

  def setX6(x: String): Unit = C3.super[X].setXX(x)

  // can't refer the "grandparent" types
  // def setX7(x:String): Unit = C3.super[C1].setX1(x) // ERROR

  /// can't chain super
  // def setX8(x:String): Unit = C3.super.super.setX1(x) // ERROR
}

/**
  * Reach a nested type with a period-delimited path expression.
  *
  * The last elements of a type path must be `stable`, i.e. packages, singleton objects, or
  * type declarations that alias the same.
  *
  * The last element in the path can be unstable, including classes, traits, and type members.
  */
package P1 {

  object O1 {

    object O2 {
      val name = "name"
    }

    class C1 {
      val name = "name"
    }

  }

}

class C7 {
  val name1 = P1.O1.O2.name
  //   val name2 = P1.O1.C1.name // ERROR - P1.O1.C1 isn't stable.
  type C1 = P1.O1.C1
  val c1 = new P1.O1.C1
}

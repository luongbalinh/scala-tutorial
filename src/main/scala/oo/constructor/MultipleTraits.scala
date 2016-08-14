package oo.constructor

/**
  * A trait can extends a class.
  *
  * The initialization of superclasses will be triggered from left to right.
  */

object MultipleTraits extends App {
  new C2

  println((new A).op + " " + (new B).op)

  new Y
  var list = List(2, 3)
  val result: List[Int] = list ++ Option(1)

}

class C1 {
  print("C1 ")
}

trait T1 extends C1 {
  print("T1 ")
}

trait T2 extends C1 {
  print("T2 ")
}

trait T3 extends C1 {
  print("T3 ")
}

class C2 extends T1 with T2 with T3 {
  println("C2 ")
}

/**
  * Diamond problem.
  *
  * It looks up the method implementation in the traits you extend from right to left.
  */

trait Base {
  def op: String
}

trait Foo extends Base {
  override def op = "foo"
}

trait Bar extends Base {
  override def op = "bar"
}

class A extends Foo with Bar

class B extends Bar with Foo

abstract class X {
  val x1: String
  val x2: String = "mom"
  println("X: " + x1 + ", " + x2)
}
class Y extends X {
  val x1: String = "hello"
  println("Y: " + x1 + ", " + x2)
}
class Z extends Y {
  override val x2: String = "dad"
  println("Z: " + x1 + ", " + x2)
}

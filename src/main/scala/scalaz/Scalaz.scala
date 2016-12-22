package scalaz

import Addable._

object Scalaz extends App {
  def sum[T](list: List[T])(implicit T: Addable[T]): T = list.reduce(T.plus)

  println(sum(List(1, 2)))
  println(sum(List(0.1, 0.2)))
  println(sum(List("A", "B")))
  println(sum(List(List("X"), List("Y", "Z"))))

}

/**
  * This is a type class (http://like-a-boss.net/2013/03/29/polymorphism-and-typeclasses-in-scala.html)
  */
trait Addable[A] {
  def plus(x: A, y: A): A
}

object Addable {
  implicit def numericAddable[T: Numeric](implicit A: Numeric[T]): Addable[T] =
    new Addable[T] {
      override def plus(x: T, y: T): T = A.plus(x, y)
    }

  implicit val stringAddable: Addable[String] = // must explicitly declare the type here
    new Addable[String] {
      override def plus(x: String, y: String): String = x + y
    }

  implicit def listAddable[T]: Addable[List[T]] = new Addable[List[T]] {
    override def plus(x: List[T], y: List[T]) = x ++ y
  }
}

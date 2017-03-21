package shapless

import shapeless.{::, HList, HNil, Poly1}
object Poly1 extends App{
  case class User(name: String)
  val list = 42 :: "Hello" :: User("Julien") :: HNil

  object plusOne extends Poly1 {
    implicit def caseInt =
      at[Int]{ _ + 1 }

    implicit def caseString =
      at[String]{ _ + 1 }

    implicit def caseUser =
      at[User]{ case User(name) =>
        User(name + 1)
      }
  }

  val result = list.map(plusOne)
  println("debug point")
}



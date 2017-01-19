package shapless

import shapeless.Generic

/**
  * Shapeless provides a way to convert case class and product types (like tuples) to HList, and vice-versa
  */
object Generic1 extends App {

  case class UserWithAge(name: String, age: Int)
  val u = UserWithAge("Julien", 30)

  val gen = Generic[UserWithAge]

  val h = gen.to(u) // Julien :: 30 :: HNil

  gen.from(h) // UserWithAge("Julien", 30)
}

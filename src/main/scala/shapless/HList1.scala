package shapless

import shapeless.{::, HList, HNil}

/**
  * A HList is a List where the type of every element is statically known at compile time.
  * Unlike Tuple, HList provides methods take, head, tail, map, flatMap, zip, etc. plus methods specific to HList.
  */
object HList1 extends App {

  case class User(name: String)

  val list = 42 :: "Hello" :: User("Julien") :: HNil
  val i = list.head

  // select finds the first element of a given type in a HList
  val s = list.select[String]
  //  list.select[List[Int]] // Compilation error

  //  val result = list match {
  //    case (_:Int) :: (_:String) :: `User` :: HNil => true
  //    case _ => false
  //  }

  // Remove first element of a type
  list.removeElem[String]

  println("debug point")
}



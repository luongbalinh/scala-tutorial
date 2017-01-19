package scalaz

import scalaz.std.option._
import scalaz.syntax.std.option._
import scalaz._
import Scalaz._

/**
  * scalaz Option always return Option[A]. None in standard Scala has type of Option[Nothing] by default
  */
object Option1 extends App {
  val test: Option[Nothing] = None

  println(some(1))
  println(none)

  val os = List(Some(42), None, Some(20))
  //  os.foldLeft(None){(acc, o) => acc orElse o} // Error
  os.foldLeft(None: Option[Int]) { (acc, o) => acc orElse o } // standard Scala
  os.foldLeft(none[Int]) { (acc, o) => acc orElse o } // with scalaz

  def xget(opt: Option[Int]) = opt | Int.MaxValue

//  import scalaz.syntax.traverse._
//
//  List(some(42), none, some(51)).concatenate
//
//  // Given a list of options, get option of list
//  List(some(42), none, some(51)).sequence
//  List(some(42), some(51)).sequence
//
//
//  import scalaz.std.map._
//  import scalaz.std.set._
//
//  val low = Map(
//    "odd" -> Set(1, 3),
//    "even" -> Set(2, 4))
//  val hi = Map(
//    "odd" -> Set(5, 7),
//    "even" -> Set(6, 8))
//  low |+| hi
//
//  // Option is Monoid
//  import scalaz.syntax.monoid._
//
//  some(2) |+| none |+| some(22)
}

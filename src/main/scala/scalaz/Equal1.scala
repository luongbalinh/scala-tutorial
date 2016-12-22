package scalaz

import scalaz._, Scalaz._

/**
  * scalaz provides === type-safe equals method =/= type-safe non-equals method).
  * They are only defined for types that provide explicit evidence of equality.
  * So 1 === "1" won't compile (no evidence of Equals[Any]).
  * This is different to the == behavior of Scala’s Any, which at best will only give a warning during compile time.
  *
  * For any types that we define, we must provide our own evidence of equality.
  */
object Equal1 extends App {
  val map = Map(
    "1.0" -> "2000",
    "2.0" -> "2001"
  )
  def isVersionFromYear(version: String, year: String): Boolean ={
    // map get version == year // Ok in standard Scala, but not type safe, comparing Option with String
//    map get version exists (_ === year)
    ???
  }

  println(isVersionFromYear("1.0", "2000"))


//  1 === 1
  //  1 == "foo" // standard Scala, return false
  //    1 === "foo" // compilation Error

}

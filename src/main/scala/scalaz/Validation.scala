package scalaz

import scalaz.syntax.validation._
import scalaz.Success
import scalaz.Failure
import scalaz.Validation

/**
  * Unlike \/ monad which cut the calculation short, Validation keeps going and reports back all failures.
  */
object Validation extends App {
  42.success[Int]
  //  val e2 = "event 2 failed!".fail[String]
  //  val e3 = "event 3 failed!".fail[String]
  //  // Problem is that the error messages are mushed together into one string
  //  val result1: Validation[String, String] = (e1 |@| e2 |@| e3) (_ + _ + _)
  //
  //  // use NonEmptyList to store errors into a list
  val e4 = "event 4 ok".successNel[String]
  val e5 = "event 5 failed!".failureNel[String]
  val e6 = "event 6 failed!".failureNel[String]
  //  val result2: Validation[NonEmptyList[String], String] = (e4 |@| e5 |@| e6) (_ + _ + _)
  println("debug point")
}

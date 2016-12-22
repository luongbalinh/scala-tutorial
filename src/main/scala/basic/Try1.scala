package basic

import java.net.URL

import scala.util.{Failure, Success, Try}

/**
  * Handle exceptions. However, its left type is fixed as Throwable.
  * Therefore, we cannot create your own error type and use it as a method result in Try
  */

object Try1 extends App {
  // use getOrElse when you do not care about the error message
  divide(1, 0) getOrElse 0

  // use match to get error message
  divide(1, 0) match {
    case Success(i) => println(s"Success, value is: $i")
    case Failure(s) => println(s"Failed, message is: $s")
  }

  // use Try to chain operations together and catch exceptions
  val x = "1"
  val y = "2"
  val z: Try[Int] = for {
    a <- Try(x.toInt)
    b <- Try(y.toInt)
  } yield a * b

  z.getOrElse(0) * 2

  // foreach, map, flatMap, filter, and for comprehension
  parseURL("http://danielwestheide.com") map (_.getProtocol)

  parseURL("garbage") map (_.getProtocol)

  def divide(x: Int, y: Int): Try[Int] = Try(x / y)

  def parseURL(url: String): Try[URL] = Try(new URL(url))

}

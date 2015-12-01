package exception

import java.net.URL

import scala.util.{Failure, Success, Try}

/**
  * Try returns failure information rather than a None (as in Option).
  * Using Try when you need the error message
  */

object MyTry extends App {
  // use getOrElse when you do not care about the error message
  divideXByY(1, 0) getOrElse 0

  // use match to get error message
  divideXByY(1, 0) match {
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

  // map Try[A] to Try[B]
  parseURL("http://danielwestheide.com").map(_.getProtocol)
  // results in Success("http")

  parseURL("garbage").map(_.getProtocol)

  // results in Failure(java.net.MalformedURLException: no protocol: garbage)

  def divideXByY(x: Int, y: Int): Try[Int] = {
    Try(x / y)
  }

  def parseURL(url: String): Try[URL] = Try(new URL(url))
}

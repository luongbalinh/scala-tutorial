package oo.extractor

import java.net.URL

/**
 * An extractor in Scala is an object that has a method called *unapply*.
 *
 * Extractor de-structures a given object into a fixed number of parameters.
 *
 * Case classes, by default, has unapply method - the method that needs to be implemented by an object in order for
 * it to be an extractor.
 *
 * Scala calls an extractor’s unapply method if the extractor is used as an extractor pattern.
 *
 */
object MyExtractor extends App {
  val user: User = new FreeUser("Daniel", 3000, 0.7d)
  val greeting = user match {
    case FreeUser(name, _, p) =>
      if (p > 0.75) name + ", what can we do for you today?" else "Hello " + name
    case PremiumUser(name, _) => "Welcome back, dear " + name
  }

  println(greeting)

  val url = new URL("http://localhost:9000")
  val urlString = URLExtractor.unapply(url)
  println(s"string representation of URL $urlString")

  val x = Twice(21)
  x match {
    case Twice(n) => println(n)
  }

  println(greet("Luong Ba Linh"))

  // unapply often returns Option
  trait User {
    def name: String

    def score: Int
  }

  class FreeUser(val name: String, val score: Int, val upgradeProbability: Double)
    extends User

  object FreeUser {
    def unapply(user: FreeUser): Option[(String, Int, Double)] = {
      Some(user.name, user.score, 0.0)
    }
  }

  class PremiumUser(val name: String, val score: Int) extends User

  object PremiumUser {
    def unapply(user: PremiumUser): Option[(String, Int)] = {
      Some(user.name, user.score)
    }
  }

  /**
   * A common usage of extractors is to extract meaningful values from some string, e.g. extract string representations
   * of a URL.
   */

  object URLExtractor {
    def unapply(url: URL): Option[(String, String, Int, String)] = {
      try {
        Some(url.getProtocol, url.getHost, url.getPort, url.getPath)
      }
      catch {
        case e: Exception => None
      }
    }
  }

  object Twice {
    def apply(x: Int): Int = x * 2

    def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
  }

  object Names {
    def unapplySeq(name: String): Option[(String, String, Array[String])] = {
      val names = name.trim.split(" ")
      if (names.size < 2) None
      else Some((names.last, names.head, names.drop(1).dropRight(1)))
    }
  }

  def greet(fullName: String) = fullName match {
    case Names(lastName, firstName, _*) => "Good morning, " + firstName + " " + lastName + "!"
    case _ => "Welcome! Please make sure to fill in your name!"
  }

}
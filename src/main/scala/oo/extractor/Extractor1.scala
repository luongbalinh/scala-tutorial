package oo.extractor

/**
  * An extractor in Scala is an object that has a method called *unapply*. Extractor de-structures a given object into
  * a fixed number of parameters.
  *
  * Case classes has unapply method by default.
  *
  * Scala calls an extractor’s unapply method for pattern matching
  *
  */
object MyExtractor extends App {
  val user: User = new FreeUser("Daniel", 0, 0)

  user match {
    case FreeUser(name, _, p) => s"free user: $name"
    case PremiumUser(name, _) => s"premium user: $name"
  }

  val number = 3
  number match {
    case EvenChecker() =>
      println(s"$number is even") // must include parentheses
    case _ => println(s"$number is odd")
  }

  "Luong Ba" match {
    case GivenNames(lastName, _ *) => println(s"Last name = $lastName")
    case _ => println("Does not have last name")

  }

  def greet(fullName: String): String = fullName match {
    case Names(lastName, firstName, _ *) =>
      "Good morning, " + firstName + " " + lastName + "!"
    case _ => "Welcome! Please make sure to fill in your name!"
  }

  "linhluongba@gmail.com" match {
    case EmailHelper(email) =>
      println(s"Valid email: name = ${email.name}, domain = ${email.domain}")
    case _ => println("Invalid email.")
  }
}

trait User {
  def name: String

  def score: Int
}

class FreeUser(val name: String,
               val score: Int,
               val upgradeProbability: Double)
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

object EvenChecker {
  def unapply(number: Int): Boolean = {
    if (number % 2 == 0) true else false
  }
}

object GivenNames {
  def unapplySeq(name: String): Option[Seq[String]] = {
    if (name.split(" ").nonEmpty) Some(name.split(" ")) else None
  }
}

object Names {
  def unapplySeq(name: String): Option[(String, String, Array[String])] = {
    val names = name.trim.split(" ")
    if (names.size < 2) {
      None
    } else {
      Some((names.last, names.head, names.drop(1).dropRight(1)))
    }
  }

  val pets = List("cat", "dog", "frog")
  Seq(1, 2, 42) collect pets // List("dog", "frog")

}

case class Email(name: String, domain: String)

object EmailHelper {
  def apply(name: String, domain: String): Option[Email] =
    Some(Email(name, domain))

  def unapply(email: String): Option[Email] = {
    val parts = email.split("@")
    if (parts.size == 2) Some(Email(parts.head, parts(1))) else None
  }
}

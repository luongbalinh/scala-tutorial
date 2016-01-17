package oo.extractor

object MyExtractor2 extends App {
  val people = List(
    Person("Emre", List(Residence("Antwerp", "BE"))),
    Person("Berk", List(Residence("Antwerp", "BE"))),
    Person("Ergin", List(Residence("Istanbul", "TR"), Residence("Ankara", "TR"))),
    Person("Ahmet", List(Residence("Istanbul", "TR")))
  )
  val Istanbul = new ResidenceListContains("Istanbul")
  people collect {
    case person@LivesIn(Istanbul()) => println(person.toString)
  }

  val livesInIstanbul = new PartialFunction[Person, String] {
    def apply(person: Person): String = person match {
      case p => p.name
    }

    def isDefinedAt(person: Person): Boolean = {
      person.residences.exists(residence => residence.name == "Istanbul")
    }
  }

  println(people.collect(livesInIstanbul))

  val invert = new PartialFunction[Double, Double] {
    def apply(x: Double): Double = {
      1.0 / x
    }

    override def isDefinedAt(x: Double): Boolean = {
      x != 0
    }
  }

  println(List(1.0, 2.0, 0.0, 4.0).collect(invert))
}

case class Person(name: String, residences: List[Residence])

object LivesIn {
  def unapply(person: Person): Option[List[Residence]] = {
    Some(person.residences)
  }
}

case class Residence(name: String, code: String)

class ResidenceListContains(residence: String) {
  def unapply(residences: List[Residence]): Boolean = {
    residences.exists(x => x.name == residence)
  }
}

package collection

object Sorting extends App {
  val names = List("Linh1", "linh")
  val result1 = names.sortWith(caseInsensitiveSort)

  private def caseInsensitiveSort(a: String, b: String): Boolean = {
    (a compareToIgnoreCase b) < 0
  }

  val map = Map(2 -> "second", 1 -> "first", 3 -> "third", 4 -> "forth")
  // sort by key
  val result2 = map.toList.sorted

  // sort by value
  val result3 = map.toList sortBy (_._2)

  case class Person(var firstName: String, var lastName: String, var city: String)

  var people = List(
    Person("Oscar", "Wilde", "London"),
    Person("Oscar", "Swift", "Berlin"),
    Person("Carl", "Swift", "Paris"),
    Person("Hans", "Swift", "Dublin"),
    Person("Hugo", "Swift", "Sligo"))

  val result4 = people.sortBy(person => (person.firstName, person.lastName))

  println("debug point")
}

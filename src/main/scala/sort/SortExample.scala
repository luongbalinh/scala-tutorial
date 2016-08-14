package sort

object SortExample extends App {
  val names = List("Linh1", "linh")
  val nameAfterSort = names.sortWith(caseInsensitiveSort)

  def caseInsensitiveSort(a: String, b: String): Boolean = {
    (a compareToIgnoreCase b) < 0
  }

  println(s"Name after sort: $nameAfterSort")

  val map = Map(2 -> "second", 1 -> "first", 3 -> "third", 4 -> "forth")
  // sort by key
  val mapSortedByKey = map.toList.sorted
  println(s"map sorted by key: $mapSortedByKey")

  // sort by value
  val mapSortedByValue = map.toList sortBy (_._2)
  println(s"map sorted by value: $mapSortedByValue")

  case class Person(var firstName: String, var lastName: String, var city: String)

  var people = List(new Person("Oscar", "Wilde", "London"),
    new Person("Otto", "Swift", "Berlin"),
    new Person("Carl", "Swift", "Paris"),
    new Person("Hans", "Swift", "Dublin"),
    new Person("Hugo", "Swift", "Sligo"))

  people.sortBy(person => (person.firstName, person.lastName))
  println(s"People after sort: $people")
}

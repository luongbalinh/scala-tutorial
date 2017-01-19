import java.time.ZonedDateTime

object Solution extends App {
  val p1= Person("linh", 10)
  println(p1.copy(name = "Linh2") == Person("Linh2", 10))
}
case class Person (name: String, age: Int)


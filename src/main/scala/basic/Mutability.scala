package basic

object Mutability extends App {
  var set1 = Set("Boeing", "Airbus")
  val set2 = set1
  set1 += "Lear"

  val numbers = scala.collection.mutable.Set("1", "2")
  numbers += "3" // still points to the same memory address

  println("debug point")
}

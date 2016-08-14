package mutability

object MyMutbility extends App {
  var jetSet1 = Set("Boeing", "Airbus")
  val jetSet2 = jetSet1
  jetSet1 += "Lear"
  assert(jetSet1.contains("Lear"))
  assert(!jetSet2.contains("Lear"))

  val numbers = scala.collection.mutable.Set("1", "2")
  numbers += "3" // still points to the same memory address
  // object pointed by a val can be updated.
  assert(numbers.contains("3"))

}

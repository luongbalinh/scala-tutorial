package shapless
import shapeless._
/**
  * Shapeless provides a simple lenses implementation
  */
object Lense1 extends App{
  case class Address(street : String, city : String, postcode : String)
  case class Person(name : String, age : Int, address : Address)

  val ageLens = lens[Person].age

  // Starting value
  val person = Person("Joe Grey", 37, Address("Southover Street", "Brighton", "BN2 9UA"))

//  // Read a field
  //  val age1 = ageLens.get(person) // Type inferred is Int
  //  typed[Int](age1)
  //  assert(age1 == 37)
  //
  //  // Update a field
  //  val person2 = ageLens.set(person)(38)
  //  assert(person2.age == 38)
}

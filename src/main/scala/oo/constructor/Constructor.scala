package oo.constructor

/**
 * Traits may not have constructor parameters.
 *
 * Objects cannot take parameters. You cannot instantiate a singleton object with the new keyword, you
 * can’t pass parameters to its primary constructor.
 *
 * use `override` to override a concrete member in a parent class.
 *
 * use `final` prevents subclasses from overriding a member of the superclass
 *
 *
 */
object Constructor {

  def main(args: Array[String]) {
    val a1 = new Address("1 Scala Lane", "Anytown", "CA", "98765")
    val a2 = new Address("98765")

    Person("Buck Trends1")
    Person("Buck Trends2", Some(20))
    Person("Buck Trends3", address = Some(a2))
    Person("Buck Trends4", Some(20), Some(a1))

    val ceo = new Employee("Joe CEO", title = "CEO")
    new Employee("Buck Trends4", Some(20), Some(a1), "Zombie Dev", Some(ceo))
  }
}

//  the primary constructor is the entire body of the class
case class Address(street: String, city: String, state: String, zip: String) {

  //  an auxiliary constructor is named this and it must call the primary constructor or another auxiliary
  // constructor as its first expression
  def this(zip: String) =
    this("[unknown]", Address.zipToCity(zip), Address.zipToState(zip), zip)
}

object Address {
  def zipToCity(zip: String) = "Anytown"

  def zipToState(zip: String) = "CA"
}

// use default values for constructor parameters to eliminate auxiliary constructors.
// If defaults values come from complicated computation, e.g. Address class above, then use auxiliary constructor.
case class Person(name: String, age: Option[Int] = None, address: Option[Address] = None) {
  // validate constructor parameters, like Google Guava
  require(validateName(name), "Invalid name")

  def validateName(name: String): Boolean = {
    name.isEmpty
  }

}

class Employee(name: String,
               age: Option[Int] = None,
               address: Option[Address] = None,
               val title: String = "[unknown]",
               val manager: Option[Employee] = None) extends Person(name, age, address) {
  override def toString = {
    s"Employee($name, $age, $address, $title, $manager)"
  }
}
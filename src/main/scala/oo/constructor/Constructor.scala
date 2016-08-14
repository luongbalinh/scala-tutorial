package oo.constructor

/**
  * Traits and objects cannot have constructor parameters.
  *
  * use `override` to override a concrete member in a parent class.
  *
  * use `final` prevents subclasses from overriding a member of the superclass
  *
  * For case class, constructor parameters are val by default, and getter is automatically generated for them.
  *
  * For non-case class, if constructor arguments have are not val/var, they will not be members of the class,
  * merely constructor arguments. However, they are accessible to methods defined in the class. Otherwise, if
  * constructor arguments are var, they are members of the class, and getter and setter are automatically generated
  * for them. If they are val, they are members of the class, and only getter is generated.
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

// the primary constructor is the entire body of the class
// use default values for constructor parameters to eliminate auxiliary constructors.
// If defaults values come from complicated computation, e.g. Address class above, then use auxiliary constructor.
case class Address(street: String, city: String, state: String, zip: String) {

  /** an auxiliary constructor is named this and it must call the primary constructor or another auxiliary
    * constructor as its first expression. This ensures that the primary constructor is the sole point of entry to
    * the class.
    */
  def this(zip: String) =
    this("[unknown]", Address.zipToCity(zip), Address.zipToState(zip), zip)
}

object Address {
  def zipToCity(zip: String) = "AnyTown"

  def zipToState(zip: String) = "CA"
}

case class Person(name: String, age: Option[Int] = None, address: Option[Address] = None) {
  // validate constructor parameters, like Google Guava
  require(validateName(name), "Invalid name")

  def validateName(name: String): Boolean = {
    name.isEmpty
  }
}

class Employee(
  name: String,
  age: Option[Int] = None,
  address: Option[Address] = None,
  val title: String = "[unknown]",
  val manager: Option[Employee] = None
) extends Person(name, age, address) {
  override def toString = {
    s"Employee($name, $age, $address, $title, $manager)"
  }
}
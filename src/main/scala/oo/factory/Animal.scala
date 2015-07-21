package oo.factory

/**
 * Concrete instances can only be created through the factory.
 * Class constructors should be hidden from all other classes.
 */
trait Animal {
  def speak
}

object Animal {

  // make Dog and Cat private to prevent creating Dog and Cat instances directly.

  private class Dog extends Animal {
    override def speak: Unit = {
      println("woof")
    }
  }

  private class Cat extends Animal {
    override def speak: Unit = {
      println("meoo")
    }
  }

  // factory method
  def apply(s: String) = s match {
    case "dog" => new Dog
    case "cat" => new Cat
  }

  // an alternative factory method (use one or the other)
  def getAnimal(s: String): Animal = {
    if (s == "dog") return new Dog
    else return new Cat
  }

}

object MyFactory extends App {
  val dog = Animal("dog")
  dog.speak

  val cat = Animal("cat")
  cat.speak

  Animal.getAnimal("dog").speak
  Animal.getAnimal("cat").speak
}

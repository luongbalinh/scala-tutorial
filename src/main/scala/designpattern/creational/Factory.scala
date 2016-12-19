package designpattern.creational

/**
 * Concrete instances can only be created through the factory.
 * Class constructors should be hidden from all other classes.
 */

object Factory1 extends App {
  Animal("dog").speak()
  Animal("cat").speak()
}

trait Animal {
  def speak()
}

object Animal {
  // make Dog and Cat private to prevent creating Dog and Cat instances directly.
  private class Dog extends Animal {
    override def speak(): Unit = {
      println("woof")
    }
  }

  private class Cat extends Animal {
    override def speak(): Unit = {
      println("meoo")
    }
  }

  // factory method
  def apply(s: String) = s match {
    case "dog" => new Dog
    case "cat" => new Cat
  }
}
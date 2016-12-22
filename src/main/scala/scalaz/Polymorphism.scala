package scalaz

import scalaz._, Scalaz._

object Polymorphism extends App {

  /**
    * 1. Subtype polymorphism (object-oriented): object's method is called depends on the runtime type of the object.
    */

  trait Animal {
    def makeSound: String
  }

  class Dog extends Animal {
    override def makeSound = "Woof"
  }

  class Cat extends Animal {
    override def makeSound = "Meow"
  }

  val dog = new Dog
  val cat = new Cat

  /**
    * 2. Parametric polymorphism (functional programming): define computations/data structures that can abstract over any type (or a subset) while writing it.
    */
  case class Box[T](value: T)

  val box1 = Box(1)
  val box2 = Box(2.3)

  /**
    * 3. Typeclass allows to define some additional behavior (methods) to the class independently from this class itself.
    * Dispatch on the compile time type
    */
  def offspringName[T](t: T)(implicit o: OffspringName[T]): String = {
    o.offspringName(t)
  }

  trait OffspringName[T] {
    def offspringName(t: T): String
  }

  // concrete type class instances
  object OffspringName {

    implicit val CatHasOffspringName = new OffspringName[Cat] {
      override def offspringName(cat: Cat) = "Kitty"
    }

    // can define as object as well
    implicit object DogHasOffspringName extends OffspringName[Dog] {
      override def offspringName(dog: Dog) = "Puppy"
    }
  }

  case class Tiger(name: String)
  object Tiger {
    implicit val TigerHasOffspringName = new OffspringName[Tiger] {
      override def offspringName(t: Tiger) = "Tiger"
    }
  }
  import OffspringName._

  offspringName(cat)
  offspringName(dog)
  offspringName(Tiger("King"))
  val catAnimal: Animal = cat
  //  offspringName(catAnimal) // ERROR
}

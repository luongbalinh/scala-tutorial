package designpattern.creational

object Factory {
  def main(args: Array[String]) {
    val dog = Animal("dog")
    dog.speak
    val cat = Animal("cat")
    cat.speak
  }
}

trait Animal {
  def speak
}

private class Dog extends Animal {
  def speak = println("woof")
}

private class Cat extends Animal {
  override def speak = println("meow")
}

object Animal {
  def apply(kind: String) = kind match {
    case "dog" => new Dog
    case "cat" => new Cat
  }
}
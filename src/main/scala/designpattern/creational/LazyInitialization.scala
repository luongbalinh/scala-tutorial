package designpattern.creational

object LazyInitialization extends App {
  lazy val x = {
    print("(computing x) ")
    42
  }

  print("x = ")
  println(x)

  // x = (computing x) 42
}

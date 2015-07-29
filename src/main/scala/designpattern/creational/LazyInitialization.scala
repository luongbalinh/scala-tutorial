package designpattern.creational

object LazyInitialization {
  def main(args: Array[String]) {
    lazy val x = {
      print("(computing x) ")
      42
    }

    print("x = ")
    println(x)

    // x = (computing x) 42
  }
}

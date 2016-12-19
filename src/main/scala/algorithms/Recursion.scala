package algorithms

import scala.annotation.tailrec

object Recursion {
  /**
    * f(1) = f(2) = 1
    */
  def fibonacci(n: Int): Int = {
    @tailrec
    def loop(a: Int, b: Int, count: Int): Int = {
      if (count == 1) {
        b
      } else {
        loop(b, a + b, count - 1)
      }
    }
    loop(1, 1, n)
  }
}

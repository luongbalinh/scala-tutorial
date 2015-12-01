package collection

/**
 * Unlike foldLeft, which is implemented using loop, foldRight is implemented using recursion, hence cannot be
 * applied to a long list.
 *
 * http://oldfashionedsoftware.com/2009/07/10/scala-code-review-foldleft-and-foldright/
 */
object Folding extends App {

  val list = List(1, 2, 3)
  // sum
  list.foldLeft(0)((a, x) => a + x)

  // proudction
  list.foldLeft(1)((a, x) => a * x)

  // return the last entity of a list
  def last[A](list: List[A]) = {
    list.foldLeft(list.head)((_, c) => c)
  }

  println(list.foldLeft(0)((_, x) => x))

  // get the penultimate entity of the list
  def penultimate[A](list: List[A]): A =
    list.foldLeft((list.head, list.tail.head))((r, c) => (r._2, c))._1

  // check a list contains a entity
  def contain[A](list: List[A], x: A): Int = {
    list.foldLeft(0)((_, e) =>
      if (e == x) return 1
      else return 0

    )
  }

  /**
   * reduce is the simplified version of foldLeft
   *
   * reduce an empty list throws an exception
   * reduce a list of a single entity return that entity
   */
  val emptyList = List.empty[Int]
  //  println(emptyList.reduce(_ + _))
  println(s"sum of empty list" + emptyList.foldLeft(0)((a, x) => a + x))
}

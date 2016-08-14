package collection

import scala.collection.mutable.ListBuffer

/**
 * A list represents a linked list. List is immutable, while ListBuffer is mutable.
 */

object MyList {
  def main(args: Array[String]): Unit = {
    val emptyList0 = Nil // Nil and List() are the same. Nil is preferred.
    val emptyList1 = List()
    val emptyList2 = List.empty[Int]

    var numbers = List(1, 2, 3, 4, 5) // syntactic sugar for list definition
    // `::` operation associates to the right
    numbers = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

    // range is exclusive at the end
    numbers = List.range(1, 6)

    /**
     * fill() creates a list consisting of zero or more copies of the same element
     */
    val threeApples = List.fill(3)("apples") // Repeats apples three times.
    println("fill(3)apples : " + threeApples)

    // tabulate index starts from 0
    val squaresNumbers = List.tabulate(5)(x => x * x)
    println(squaresNumbers)

    val twoDimensionalList: List[List[Int]] =
      List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )

    /**
     * Basic operations on lists
     */
    println(s"numbers is empty: ${numbers.isEmpty}")
    println(s"numbers's head: ${numbers.head}") // only for non-empty lists
    println(s"numbers's tail: ${numbers.tail}") // only for non-empty lists
    println(s"numbers's init: ${numbers.init}") // only for non-empty lists
    println(s"numbers's last: ${numbers.last}") // only for non-empty lists
    println(s"numbers reversed: ${numbers.reverse}")
    println(s"numbers take 2: ${numbers.take(2)}")
    println(s"numbers drop 2: ${numbers.drop(2)}")
    println(s"numbers split 2: ${numbers.splitAt(2)}")

    /**
     * Concatenates lists.
     * Note that List is immutable
     *
     */
    val fruit1 = List("apples", "oranges")
    val fruit2 = List("banana")

    // ++
    var fruit = fruit1 ++ fruit2 // ++ is preferred to :::
    fruit = fruit1 :+ "banana"

    // xs ::: ys ::: zs = xs ::: (ys ::: zs) = zs.:::(ys).:::(xs)
    println(s"fruit1 ::: fruit2 : ${fruit1 ::: fruit2}")
    println("fruit1.:::(fruit2) : " + fruit1.:::(fruit2))

    // List.concat()
    println("List.concat(fruit1, fruit2) : " + List.concat(fruit1, fruit2))

    /**
     * zip lists. The longer one of the two is truncated
     */

    println(s"zip numbers and fruit: ${numbers zip fruit}")

    /**
     * high-order functions on lists
     */

    // transform
    val scaledNumbers = numbers map (x => x * 2)
    println(s"numbers * 2: $scaledNumbers")

    def column[A](matrix: List[List[A]], index: Int): List[A] = matrix map {
      row => row(index)
    }
    // sort
    val evenNumbers: List[Int] = numbers filter (x => x % 2 == 0)
    println(s"evenNumbers : $evenNumbers")

    // foldLeft
    val sumSquares = numbers.foldLeft(0.0)((x, y) => Math.pow(x, 2) + Math.pow(y, 2))
    println(s"sumSquares using foldLeft: $sumSquares")

    // reduce
    val sumSquares2 = numbers.reduce((x, y) => x * x + y * y)
    println(s"sumSquares using reduce: $sumSquares2")

    /**
     * ListBuffer: a mutable list
     */
    var animals = new ListBuffer[String]()
    animals += "Dog"
    animals += "Cat"

    // convert ListBuffer to a List
    val animalsList = animals.toList
  }

}
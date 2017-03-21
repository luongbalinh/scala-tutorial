package collection

import scala.collection.mutable.ListBuffer

/**
  * A list represents a linked list. List is immutable, while ListBuffer is mutable.
  */

object List1 extends App {
  val emptyList0 = Nil
  // Nil and List() are the same. Nil is preferred.
  val emptyList1 = List()
  val emptyList2 = List.empty[Int]

  var numbers = List(1, 2, 3, 4, 5) // syntactic sugar for list definition
  // `::` operation associates to the right
  numbers = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

  // range is exclusive at the end
  numbers = List.range(1, 6)

  // Repeats apples three times
  val threeApples = List.fill(3)("apples")

  // tabulate index starts from 0
  val squaresNumbers = List.tabulate(5)(x => x * x)

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

  // ++ is preferred to :::
  var fruit = fruit1 ++ fruit2
  fruit = fruit1 :+ "banana"

  // xs ::: ys ::: zs = xs ::: (ys ::: zs) = zs.:::(ys).:::(xs)

  List.concat(fruit1, fruit2)

  // zip lists. The longer one of the two is truncated
  numbers zip fruit

  val scaledNumbers = numbers map (x => x * 2)

  def column[A](matrix: List[List[A]], index: Int): List[A] = matrix map {
    row => row(index)
  }

  // filter
  val evenNumbers: List[Int] = numbers filter (x => x % 2 == 0)

  // foldLeft
  val sumSquares = numbers.foldLeft(0.0)((x, y) => Math.pow(x, 2) + Math.pow(y, 2))

  // reduce
  val sumSquares2 = numbers.reduce((x, y) => x * x + y * y)

  // Amutable list
  var animals = new ListBuffer[String]()
  animals += "Dog"
  animals += "Cat"

  // convert ListBuffer to List
  val animalsList = animals.toList
}
//package typesystem
//
//import Add._
//
//object ValueType {
//  def main(args: Array[String]) {
//
//    // tuple type
//    val t1: Tuple3[String, Int, Double] = ("one", 2, 3.14)
//
//    /**
//     * Infix types
//     */
//    val left1: Either[String, Int] = Left("hello")
//    val left2: String Either Int = Left("hello")
//    val right1: Either[String, Int] = Right(1)
//    val right2: String Either Int = Right(2)
//
//
//
//    sumSeq(Vector(1 -> 10, 2 -> 20, 3 -> 30)) // Result: (6,60)
//    sumSeq(1 to 10) // Result: 55
//    // sumSeq(Option(2)) // Error!
//  }
//
//  def sumSeq[T : Add](seq: Seq[T]): T = seq reduce (implicitly[Add[T]].add(_,_))
//}
//
///**
// * Higher-Kinded Types
// */
//
//// Generalizes the notion of addition to a type class
//trait Add[T] {
//  def add(t1: T, T2: T): T
//}
//
///**
// * A companion object that defines instances of the trait as implicit values of Add for Ints and pairs of Ints
// */
//
//object Add {
//  implicit val addInt = new Add[Int] {
//    def add(i1: Int, i2: Int): Int = i1 + i2
//  }
//  implicit val addIntIntPair = new Add[(Int, Int)] {
//    def add(p1: (Int, Int), p2: (Int, Int)): (Int, Int) =
//      (p1._1 + p2._1, p1._2 + p2._2)
//  }
//}
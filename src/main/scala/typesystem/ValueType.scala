//package typesystem
//import Add.addInt
//import Add.addIntIntPair
//
//object ValueType extends App {
//  sumSeq(Vector(1 -> 10, 2 -> 20, 3 -> 30)) // (6,60)
//  sumSeq(1 to 10) // 55
//  // sumSeq(Option(2)) // Error!
//  def sumSeq[T: Add](seq: Seq[T]): T = seq reduce (implicitly[Add[T]].add(_, _))
//}
//
///**
//  * Higher-Kinded Types
//  */
//trait Add[T] {
//  def add(t1: T, T2: T): T
//}
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
//package algorithms.sort
//
//object MergeSort extends App {
//
//  def mergeSort[A](list: List[A]): List[A] = list match {
//    case Nil => Nil
//    case _ =>
//      val parts: (List[A], List[A]) = halfify(list)
//      merge(mergeSort(parts._1), mergeSort(parts._2))
//  }
//
//  private def merge[A](list1: List[A], list2: List[A]): List[A] = {
//    def loop(list1: List[A], list2: List[A], result: List[A]) = list1.head < list2.head match {
//      case true => loop(list1.tail, list2, result :+ list1.head)
//      case false => loop(list1, list2.tail, result :+ list2.head)
//    }
//  }
//
//  private def halfify[A](list: List[A]): (List[A], List[A]) = {
//    def loop(list: List[A], result: (List[A], List[A])): (List[A], List[A]) = list match {
//      case Nil => result
//      case first :: Nil => (result._1 :+ first, result._2)
//      case first :: second :: tail => loop(tail, (result._1 :+ first, result._2 :+ second))
//    }
//    loop(list, (List[A](), List[A]()))
//  }
//
//}

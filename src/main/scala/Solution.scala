import scala.reflect.ClassTag

object Solution extends App {
//  object Extractor {
//    def extract[T](list: List[Any]): List[T] = list.flatMap {
//      case element: T => Some(element)
//      case _ => None
//    }
//  }
//
//  val list = List(1, "string1", List(), "string2")
//  val result = Extractor.extract[String](list)
//  println(result) // List(1, string1, List(), string2)

  def createArray[T: ClassTag](length: Int, element: T) = new Array[T](length)
  val result = createArray(5, 1.0)
  println("debug point")
}


package shapless
import shapeless.syntax.std.tuple._

/**
  * enrich standard Scala Tuple with `head` and `tail`, `concatenate`, access to elements by an index like Seq
  */
object Tuple1 extends App{
  val t1 = ("Scala", 1, true)
  t1.head
  t1.tail
  t1(2)
  t1 :+ "yay"
  t1 ++ ("yay", 5.0)

}

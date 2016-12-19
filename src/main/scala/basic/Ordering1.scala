package basic

object MyOrdering extends App {
  val p1 = Person(10)
  val p2 = Person(20)
  assert(p1 < p2)

  val list = List(IntBox(1), IntBox(2), IntBox(3), IntBox(2), IntBox(1))
  val sort = new Sort(new BoxOrdering(scala.math.Ordering.Int))
  println(sort(list))
}
case class Person(age: Int) extends Ordered[Person] {
  override def compare(that: Person): Int = {
    age - that.age
  }
}

trait Box[T] {
  def value: T
}

class BoxOrdering[T](ordering: Ordering[T]) extends Ordering[Box[T]] {
  override def compare(x: Box[T], y:Box[T]): Int = {
    ordering.compare(x.value, y.value)
  }
}

case class IntBox(value: Int) extends Box[Int]

class Sort[T](ordering: Ordering[Box[T]]) {
  def apply(boxes: List[Box[T]]): List[Box[T]] = {
    boxes.sorted(ordering)
  }
}

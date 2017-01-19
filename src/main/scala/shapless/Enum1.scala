package shapless

import shapeless._

object Enum1 extends App {

  import WeekDay._

  def isWorkingDay(d: WeekDay): Boolean = !(d == Sat || d == Sun)

  def isWeekend(d: WeekDay): Boolean = d match {
    case Sat | Sun => true
    //    case _ => false // compile time non-exhaustive match warning/error without this case
  }

  assert((WeekDay.values filter isWorkingDay) == Set(Mon, Tue, Wed, Thu, Fri))
}

sealed trait WeekDay

object WeekDay {
  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = new WeekDay {}
//  val Sun = new WeekDay {
//    val name = "Happy day"
//  }
  val values: Set[WeekDay] = Values
}

object Values {
  implicit def conv[T](self: this.type)(implicit v: MkValues[T]): Set[T] = Values[T]

  def apply[T](implicit v: MkValues[T]): Set[T] = v.values.toSet

  trait MkValues[T] {
    def values: List[T]
  }

  object MkValues {
    implicit def values[T, Repr <: Coproduct]
    (implicit gen: Generic.Aux[T, Repr], v: Aux[T, Repr]): MkValues[T] =
      new MkValues[T] {
        def values = v.values
      }

    trait Aux[T, Repr] {
      def values: List[T]
    }

    object Aux {
      implicit def cnilAux[A]: Aux[A, CNil] =
        new Aux[A, CNil] {
          def values = Nil
        }

      implicit def cconsAux[T, L <: T, R <: Coproduct]
      (implicit l: Witness.Aux[L], r: Aux[T, R]): Aux[T, L :+: R] =
        new Aux[T, L :+: R] {
          def values = l.value :: r.values
        }
    }

  }

}

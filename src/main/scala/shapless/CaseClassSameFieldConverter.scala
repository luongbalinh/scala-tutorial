package shapless

import shapeless.{HList, HNil, LabelledGeneric}
import shapeless.ops.hlist.{Align, Intersection}
import shapeless.ops.record.Merger

object CaseClassSameFieldConverter extends App {

  class SameFieldConverter[T] {
    def apply[S, SR <: HList, TR <: HList, MR <: HList, IR <: HList](s: S)(implicit
      genS: LabelledGeneric.Aux[S, SR],
      genT: LabelledGeneric.Aux[T, TR],
      merger: Merger.Aux[SR, HNil, MR],
      intersection: Intersection.Aux[MR, TR, IR],
      align: Align[IR, TR]): T = genT.from(intersection(merger(genS.to(s), HNil)))
  }

  def convertTo[T] = new SameFieldConverter[T]

  val result = convertTo[Bar](Foo("One", "middle", false))

  println("debug point")
}

case class Foo(one: String, two: String, three: Boolean)

case class Bar(three: Boolean, two: String)

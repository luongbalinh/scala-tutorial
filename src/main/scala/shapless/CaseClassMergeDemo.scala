package shapless

import shapeless._

object CaseClassMergeDemo extends App {

  import mergeSyntax._

  case class Foo(i: Int, s: String, b: Boolean)

  case class Bar(b: Boolean, s: String)

  val foo = Foo(23, "foo", true)
  val bar = Bar(false, "bar")

  val merged = foo merge bar
  assert(merged == Foo(23, "bar", false))
}

object mergeSyntax {

  implicit class MergeSyntax[T](t: T) {
    def merge[U](u: U)(implicit merge: CaseClassMerge[T, U]): T = merge(t, u)
  }

}

trait CaseClassMerge[T, U] {
  def apply(t: T, u: U): T
}

object CaseClassMerge {

  import ops.record.Merger

  def apply[T, U](implicit merge: CaseClassMerge[T, U]): CaseClassMerge[T, U] = merge

  implicit def mkCCMerge[T, U, RT <: HList, RU <: HList]
  (implicit
    tgen: LabelledGeneric.Aux[T, RT],
    ugen: LabelledGeneric.Aux[U, RU],
    merger: Merger.Aux[RT, RU, RT]
  ): CaseClassMerge[T, U] =
    new CaseClassMerge[T, U] {
      def apply(t: T, u: U): T =
        tgen.from(merger(tgen.to(t), ugen.to(u)))
    }
}

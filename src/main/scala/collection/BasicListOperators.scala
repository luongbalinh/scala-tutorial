package collection

object BasicListOperators {
  def main(args: Array[String]) {
    (1 to 10).tail
    (1 to 10).init
    (1 to 10).filter(_ % 2 == 0)
    (1 to 10).filterNot(_ % 2 == 0)
    (1 to 10).withFilter(_ % 2 == 0)
    (1 to 10).slice(3, 7)
    (1 to 10).take(5)
    (1 to 10).drop(5)

    // Sub-division
    (1 to 10).splitAt(7)
    (1 to 10).span(_ % 2 == 0)
    (1 to 10).partition(_ > 7)



    (1 to 10).groupBy[String] {
      case n if n % 2 == 0 => "even"
      case _ => "odd"
    }

    // Element tests
    (1 to 25).exists(_ == 24)
    (1 to 25).forall(_ > -1)
    (1 to 25).count(_ > 20)
    // Simple reductions
    (1 to 10).sum
    (1 to 5).product
    List(5, 3, 1, 7).max
    List(5, 3, 1, 7).min
  }
}

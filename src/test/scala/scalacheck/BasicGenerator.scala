package scalacheck

import org.scalacheck.Gen

object BasicGenerator {

  // generate tuples of two integers and one of the is as least twice as big as the other
  val tupleGen = for {
    n <- Gen.choose(10, 20)
    m <- Gen.choose(n * 2, 500)
  } yield (n, m)

  // pick one value out of a selection of values with uniform distribution
  val vowelGen = Gen.oneOf('A', 'E', 'I', 'O', 'U', 'Y')

  // non-uniform distribution
  val vowel = Gen.frequency(
    (3, 'A'),
    (4, 'E'),
    (2, 'I'),
    (3, 'O'),
    (1, 'U'),
    (1, 'Y')
  )
}

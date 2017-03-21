package scalacheck

import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop._

object StringSpec extends Properties("Test a") {

  // Compound property
  val startsWith = forAll { (a: String, b: String) =>
    (a + b).startsWith(a)
  }
  val endsWith = forAll { (a: String, b: String) =>
    (a + b).endsWith(b)
  }
  property("String") = startsWith && endsWith

  // give forAll a specific data generator
  val smallInteger = Gen.choose(0, 100)

  property("propSmallInteger") = forAll(smallInteger)(n => n >= 0 && n <= 100)

  // user implication operator ==> to define constraints
  val propMakeList = forAll { n: Int =>
    (n >= 0 && n < 10000) ==> (List.fill(n)("").length == n)
  }
}
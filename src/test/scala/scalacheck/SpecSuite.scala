package scalacheck

import org.scalacheck.Properties

object SpecSuite extends Properties("SpecSuite") {
  include(StringSpec)
}

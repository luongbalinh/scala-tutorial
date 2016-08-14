package visibility.priv.thi

package scopeA {

class PrivateClass1(private[this] val privateField1: Int) {
  private[this] val privateField2 = 1

  //    def equalFields(other: PrivateClass1) =
  //      (privateField1 == other.privateField1) && // ERROR
  //      (privateField2 == other.privateField2) && // ERROR
  //      (nested == other.nested) // ERROR

  class Nested {
    private[this] val nestedField = 1
  }

  private[this] val nested = new Nested
}

class PrivateClass2 extends PrivateClass1(1) {
  //  privateField1 // ERROR
  //  privateField2 // ERROR
  //  new Nested().nestedField // ERROR
}

class PrivateClass3 {
  val privateClass1 = new PrivateClass1(1)
  //  privateClass1.privateField1 // ERROR
  //  privateClass1.privateField2 // ERROR
  //  privateClass1.nested.nestedField // ERROR
}

}

package visibility.priv.typ

package scopeA {

class PrivateClass1(private[PrivateClass1] val privateField1: Int) {
  private[PrivateClass1] val privateField2 = 1

  //    def equalFields(other: PrivateClass1) =
  //      (privateField1 == other.privateField1) &&
  //      (privateField2 == other.privateField2) &&
  //      (nested  == other.nested)

  class Nested {
    private[Nested] val nestedField = 1
  }

  private[PrivateClass1] val nested = new Nested
  //    nested.nestedField   // ERROR
}

class PrivateClass2 extends PrivateClass1(1) {
  //    privateField1  // ERROR
  //    privateField2  // ERROR
  //    new Nested().nestedField  // ERROR
}

class PrivateClass3 {
  val privateClass1 = new PrivateClass1(1)
  //  privateClass1.privateField1 // ERROR
  //  privateClass1.privateField2 // ERROR
  //  privateClass1.nested.nestedField // ERROR
}

}

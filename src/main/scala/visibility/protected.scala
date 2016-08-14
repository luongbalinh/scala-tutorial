
package scopeA {

class ProtectedClass1(protected val protectedField1: Int) {
  protected val protectedField2 = 1

  def equalFields(other: ProtectedClass1) =
    (protectedField1 == other.protectedField1) &&
        (protectedField2 == other.protectedField2) &&
        (nested == other.nested)

  class Nested {
    protected val nestedField = 1
  }

  protected val nested = new Nested
}

class ProtectedClass2 extends ProtectedClass1(1) {
  protectedField1
  protectedField2
  //    new Nested().nestedField  // ERROR
}

class ProtectedClass3 {
  val protectedClass1 = new ProtectedClass1(1)
  //    protectedClass1.protectedField1 // ERROR
  //    protectedClass1.protectedField2 // ERROR
  //    protectedClass1.nested.nestedField // ERROR
}

protected class ProtectedClass4

class ProtectedClass5 extends ProtectedClass4

protected class ProtectedClass6 extends ProtectedClass4

}

package scopeB {
//  class ProtectedClass4B extends scopeA.ProtectedClass4 // ERROR
}

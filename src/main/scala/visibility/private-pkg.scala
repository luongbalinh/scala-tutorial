package visibility.priv.pkg

package scopeA {

class PrivateClass1 {
  private[scopeA] val privateField = 1

  class Nested {
    private[scopeA] val nestedField = 1
  }

  private[scopeA] val nested = new Nested
}

class PrivateClass2 extends PrivateClass1 {
  // privateField
  // new Nested().nestedField
}

class PrivateClass3 {
  val privateClass1 = new PrivateClass1
  // privateClass1.privateField
  // privateClass1.nested.nestedField
}

package scopeA2 {

class PrivateClass4 {
  private[scopeA2] val field1 = 1
  private[scopeA] val field2 = 2
}

}

class PrivateClass5 {
  val privateClass4 = new scopeA2.PrivateClass4
  //  privateClass4.field1// ERROR
  val field2 = privateClass4.field2
}

}

package scopeB {

class PrivateClass1B extends scopeA.PrivateClass1 {
  // privateField   // ERROR
  val privateClass1 = new scopeA.PrivateClass1
  // privateClass1.privateField // ERROR
}

}

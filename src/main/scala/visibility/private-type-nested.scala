package visibility.priv.typ.nested

class PrivateClass1 {

  class Nested {
    private[PrivateClass1] val nestedField = 1
  }

  private[PrivateClass1] val nested = new Nested
  val nestedNested = nested.nestedField
}

class PrivateClass2 extends PrivateClass1 {
  //  new Nested().nestedField // ERROR
}

class PrivateClass3 {
  val privateClass1 = new PrivateClass1
  //   privateClass1.nested.nestedField // ERROR
}

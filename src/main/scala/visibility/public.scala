package scopeA {

class PublicClass1 {
  val publicField = 1

  class Nested {
    val nestedField = 1
  }

  val nested = new Nested
}

class PublicClass2 extends PublicClass1 {
  publicField + 1
  new Nested().nestedField
}

}

package scopeB {

class PublicClass1B extends scopeA.PublicClass1

class UsingClass(val publicClass: scopeA.PublicClass1) {
  publicClass.publicField
  publicClass.nested.nestedField
}

}

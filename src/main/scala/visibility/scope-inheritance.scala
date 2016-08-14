package scopeA {

class Class1 {
  private[scopeA] val scopeA_privateField = 1
  protected[scopeA] val scopeA_protectedField = 2
  private[Class1] val class1_privateField = 3
  protected[Class1] val class1_protectedField = 4
  private[this] val this_privateField = 5
  protected[this] val this_protectedField = 6
}

class Class2 extends Class1 {
  scopeA_privateField
  scopeA_protectedField
  //    class1_privateField     // ERROR
  class1_protectedField
  //    this_privateField       // ERROR
  this_protectedField
}

}

package scopeB {

class Class2B extends scopeA.Class1 {
  // scopeA_privateField     // ERROR
  scopeA_protectedField
  // class1_privateField     // ERROR
  class1_protectedField
  // this_privateField       // ERROR
  this_protectedField
}

}

package oo.overriding

object Linearization extends App {
  val c2 = new Class2
  c2.m // Result: Class2 T3 T2 T1 Class1
}

class Class1 {
  def m = print("Class1 ")
}

trait T1 extends Class1 {
  override def m = {
    print("T1 ")
    super.m
  }
}

trait T2 extends Class1 {
  override def m = {
    print("T2 ")
    super.m
  }
}

trait T3 extends Class1 {
  override def m = {
    print("T3 ")
    super.m
  }
}

class Class2 extends T1 with T2 with T3 {
  override def m = {
    print("Class2 ")
      super.m
  }
}

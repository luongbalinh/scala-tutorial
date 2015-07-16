package visibility.priv.pkg.typ

package scopeA {

private[scopeA] class PrivateClass1

package scopeA2 {

private[scopeA2] class PrivateClass2

private[scopeA] class PrivateClass3

}

class PrivateClass4 extends PrivateClass1

protected class PrivateClass5 extends PrivateClass1

private class PrivateClass6 extends PrivateClass1

private[this] class PrivateClass7 extends PrivateClass1

//  private[this] class PrivateClass8 extends scopeA2.PrivateClass2 // ERROR
private[this] class PrivateClass9 extends scopeA2.PrivateClass3

}

package scopeB {

//class PrivateClass1B extends scopeA.PrivateClass1 // ERROR
}

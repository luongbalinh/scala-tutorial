package designpattern

import scala.util.Try

/**
 * Created by Luong on 29/7/15.
 */
object DesignByContract {
  def main(args: Array[String]) {
    Seq(-10, 0, 10) foreach (i => println(f"$i%3d: ${Try(Money(i))}"))
    val ba1 = BankAccount(Money(10.0))
    val ba2 = ba1.credit(Money(5.0))
    val ba3 = ba2.debit(Money(8.5))
    val ba4 = Try(ba3.debit(Money(10.0)))
    println( s"""
                |Initial state: $ba1
        |After credit of $$5.0: $ba2
        |After debit of $$8.5: $ba3
        |After debit of $$10.0: $ba4""".stripMargin)
  }

}

/**
 * preconditions with `require` to test method arguments (including constructors). They throw
 * IllegalArgumentException on failure and their code generation is not affected by the -Xelide-below option.
 *
 * The `assert` and `assume` methods behave identically. The names signal different intent. `assert` is used for
 * invariants. Both throw AssertionError on failure and both can be completely removed from the byte code if you
 * compile with the option -Xelide-below ASSERTION
 *
 * `assert` and `assume` should be turned off in production to follow  `let it crash` philosophy
 */

case class Money(val amount: Double) {
  require(amount >= 0.0, s"Negative amount $amount not allowed")

  def +(m: Money): Money = Money(amount + m.amount)

  def -(m: Money): Money = Money(amount - m.amount)

  def >=(m: Money): Boolean = amount >= m.amount
}

case class BankAccount(balance: Money) {
  def debit(amount: Money) = {

    // invariant condition of BacnkAccount
    assert(balance >= amount,
      s"Overdrafts are not permitted, balance = $balance, debit = $amount")
    new BankAccount(balance - amount)
  }

  def credit(amount: Money) = {
    new BankAccount(balance + amount)
  }
}

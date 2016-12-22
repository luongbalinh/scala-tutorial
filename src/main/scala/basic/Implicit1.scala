package basic

/**
  * 1. implicit parameters
  *
  * Populate a method argument. To function as an implicit value, it must not take arguments itself,
  * unless the arguments are also implicit.
  */

object MyImplicit extends App {
  def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate

  {
    val amount = 100F
    import SimpleStateSalesTax.rate
    println(s"Simple tax on $amount = ${calcTax(amount)}")
  }
  {
    val amount = 100F
    import ComplicatedSalesTax.rate
    implicit val myStore = ComplicatedSalesTaxData(0.06F, isTaxHoliday = false, 1010)
    println(s"Complicated tax on $amount = ${calcTax(amount)}")
  }

  object SimpleStateSalesTax {
    implicit val rate: Float = 0.05F
  }

  case class ComplicatedSalesTaxData(baseRate: Float, isTaxHoliday: Boolean, storeId: Int)

  object ComplicatedSalesTax {
    private def extraTaxRateForStore(id: Int): Float = {
      0.0F
    }

    implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float =
      if (cstd.isTaxHoliday) {
        0.0F
      }
      else {
        cstd.baseRate + extraTaxRateForStore(cstd.storeId)
      }
  }

  /**
    * 2. Implicit conversions
    */

  case class Person(name: String) {
    def greet: String = s"Hello! I'm $name"
  }

  object Person {
    implicit def stringToPerson(str: String): Person = Person(str)
  }

  import Person._

  "Joe".greet

  /**
    * Shortcut for implicit conversion is implicit class
    */

  implicit class StringToPerson(str: String) {
    def greet2: String = s"Hello! I'm $str"
  }

}

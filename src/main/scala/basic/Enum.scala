package basic

// https://github.com/lloydmeta/enumeratum

/**
  * They don’t inter-operate with Java’s enum.
  */
object Enum extends App {

  import WeekDay._

  val result1 = WeekDay.values filter isWeekend foreach println
  val result2 = WeekDay.withName("Mon")
  val result3 = WeekDay.valueOf("Mon")
  object Functions {
    def f(x: WeekDay) = "A weekday"

    //    def f(x: DeliveryStatus.Value) = "A delivery status" // ERROR
  }

  def patternMatching(day: WeekDay) = day match {
    case Mon => "Go"
  }
  val result4 = Mon < Tue
}

/**
  * Disadvantages of Enumeration:
  * 1. Enumerations have the same type after erasure.
  * 2. There’s no exhaustive matching warning during compile.
  * 3. Enumeration is ordered out of the box.
  */

object WeekDay extends Enumeration {
  type WeekDay = Value

  val Mon, Tue, Wed, Thu, Fri, Sat = Value
  val Sun = Value("Sun")

  def isWeekend(d: WeekDay): Boolean = d match {
    case Sat | Sun => true
    // missing case ... still compiles
  }

  /**
    * The built-in withName() will throw an exception if there is no match. Therefore, it is better to implement valueOf
    * that returns an Option.
    */

  def valueOf(name: String): Option[WeekDay] = {
    WeekDay.values.find(_.toString == name) match {
      case Some(weekDay) => Some(weekDay)
      case None => None
    }
  }
}

object DeliveryStatus extends Enumeration {
  type DeliveryStatus = Value
  val Pending = Value(1, "pending")
  val Delivered = Value(2, "delivered")

  def getDescription(code: Int): Option[String] = {
    DeliveryStatus.values.find(_.id == code) match {
      case Some(errorCode) => Some(errorCode.toString)
      case None => None
    }
  }
}

/**
  * Disadvantages of using traits as enums:
  * 1. Can't iterate over all instances of the "enumeration"
  * 2. Can't instantiate easily from persisted value
  * 3. case object based enum is not ordered
  */

sealed trait Currency {
  def code: Int

  def name: String
}

case object EUR extends Currency {
  val code = 1
  val name = "EUR"
}

case class UnknownCurrency(name: String, code: Int) extends Currency


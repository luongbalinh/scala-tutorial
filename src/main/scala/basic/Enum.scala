package basic

// https://github.com/lloydmeta/enumeratum
object Enum extends App {

  import WeekDay._

  WeekDay.values filter isWorkingDay foreach println
  WeekDay.withName("Mon")
  WeekDay.valueOf("Mon")
}

/**
  * Scala Enumeration is good for creating groups of related constants.
  * Enumeration enum is ordered out of the box.
  */

object WeekDay extends Enumeration {
  type WeekDay = Value

  val Mon = Value("Mon")
  val Tue = Value("Tue")
  val Wed = Value("Wed")
  val Thu = Value("Thu")
  val Fri = Value("Fri")
  val Sat = Value("Sat")
  val Sun = Value("Sun")

  def isWorkingDay(d: WeekDay): Boolean = d != Sat && d != Sun

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
  * Using traits as enums
  * Disadvantages:
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


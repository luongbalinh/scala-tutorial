package circe

object EnrichedEventType extends Enumeration {
  type EnrichedEventType = Value

  val WIN = Value(1)
  val CLICK = Value(2)
  val CONVERSION = Value(3)
  val BID = Value(4)
}

package typesystem

object TypeProjection {
  def main(args: Array[String]) {
    // val l1: Service.Log = new ConsoleLogger // ERROR: no object Service
    // val l2: Service1.Log = new ConsoleLogger // ERROR: no object Service1
    // val l3: Service#Log = new ConsoleLogger // ERROR: does not type check
    val l4: Service1#Log = new ConsoleLogger // OK: type check statically

    // Singleton types
    val s11 = new Service1
    val s12 = new Service1
    val l1: Logger = s11.logger
    val l11: s11.logger.type = s11.logger
    // val l12: s11.logger.type = s12.logger // ERROR: path-dependent type
  }
}

trait Logger {
  def log(message: String): Unit
}

class ConsoleLogger extends Logger {
  def log(message: String): Unit = println(s"log: $message")
}

trait Service0 {
  type Log <: Logger
  val logger: Log
}

class Service1 extends Service0 {
  type Log = ConsoleLogger
  override val logger: ConsoleLogger = new ConsoleLogger
}
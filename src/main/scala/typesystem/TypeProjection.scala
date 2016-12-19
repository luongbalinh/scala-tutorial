package typesystem

object TypeProjection extends App {
  val l4: Service1#Log = new ConsoleLogger // OK: type check statically

  // Singleton types
  val s1 = new Service1
  val s2 = new Service1
  val l1: Logger = s1.logger
  val l2: s1.logger.type = s1.logger
  //  val l3: s1.logger.type = s2.logger // ERROR: path-dependent type
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
  override val logger = new ConsoleLogger
}
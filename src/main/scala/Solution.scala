import org.slf4j.{LoggerFactory, MDC}

object Solution extends App {
  MDC.put("first", "linh")
  MDC.put("last", "linh")


  val logger = LoggerFactory.getLogger(getClass)
  logger.info("msg 1")
  logger.info("msg 2")
}


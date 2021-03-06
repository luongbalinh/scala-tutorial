package basic

object Either1 extends App {
  /**
    * Handle exception. However, Either doesn't really have any bias.
    * it is only a convention that Right is a value storage and Left is an exception storage.
    * The Either itself doesn't have map/flatMap methods, so in order to use it in for comprehensions,
    * we would need to switch to Either projections and it is not as convenient as it should be.
    */
  def queryNextNumber: Either[Exception, Long] = {
    val source = Math.round(Math.random * 100)
    if (source <= 60) Right(source)
    else Left(new Exception("The generated number is too big!"))
  }

  sealed trait Success

  object success extends Success {
    override def toString: String = "success"
  }

  case class Failed(msg: String)

  def write(): Either[Failed, Success] = {
    Right(success)
  }

  def log(): Either[Failed, Success] = {
    Left(Failed("in log"))
  }

  def run(): Either[Failed, Success] = {
    //    write().map(_ => log()) // compilation ERROR
    ???
  }
}

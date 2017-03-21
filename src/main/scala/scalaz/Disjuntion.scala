package scalaz

import scalaz._, Scalaz._

/**
  * \/ is right biased, which means that all operations like map, flatMap, comprehension, etc. work on the "right" part of the type,
  * which by convention is the success part
  */
object Disjuntion extends App {
  def queryNextNumber1: Exception \/ Long = {
    val source = Math.round(Math.random * 100)
    if (source <= 60) \/-(source)
    else -\/(new Exception("The generated number is too big!"))
  }

  println(queryNextNumber1)

  def queryNextNumber2: Throwable \/ Long = \/.fromTryCatchNonFatal {
    val source = Math.round(Math.random * 100)
    if (source <= 60) source
    else throw new Exception("The generated number is too big!")
  }

  class GenerationException(number: Long, message: String) extends Exception(message)

  implicit val geNotNothing = NotNothing.isNotNothing[GenerationException]

  def queryNextNumber: GenerationException \/ Long = \/.fromTryCatchThrowable {
    val source = Math.round(Math.random * 100)
    if (source <= 60) source
    else throw new GenerationException(source, "The generated number is too big!")
  }
}
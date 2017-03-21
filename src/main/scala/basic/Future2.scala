package basic

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps
import scala.util.{Failure, Success}

/**
  * Wrap a code block in Future does not make it non-blocking, it just means the block will be executed in a different thread.
  * You still need to make sure that the thread pool that you are using has enough threads to handle the blocking.
  *
  * The default execution context runs your futures on daemon threads which doesn't stop the JVM from exiting.
  */


object Future2 extends App {
  val f1 = Future {
    sleep(500)
    2
  }

  def f2(x: Int): Future[Int] = Future {
    sleep(500)
    x + 2
  }

  /**
    * 1. Blocking: wait for UP to 1 second
    */
  val result = Await.result(f1, 1 second)
  println(s"f1's result = $result")

  /**
    * 2. Handle Future's result using callback, e.g. onComplete
    * A callback method is executed by some thread, some time after the future is completed. From the Scala Futures
    * documentation, "There is no guarantee that it will be called by the thread that completed the future or the
    * thread that created the callback."
    *
    * The order in which callbacks are executed is not guaranteed.
    *
    * onComplete, onSuccess, and onFailure have the result type Unit, so they can’t be chained. This design was
    * intentional, to avoid any suggestion that callbacks may be executed in a particular order.
    */

  f2(0) onComplete {
    case Success(x) => println(s"f2's result = $x")
    case Failure(e) => e.printStackTrace()
  }

  println("A ...")
  sleep(100)
  println("B ...")
  sleep(100)
  println("C ...")
  sleep(100)
  println("D ...")
  sleep(100)

  // keep the JVM running
  sleep(2000)

  /**
    * 2. Handle result using map/flatMap
    */

  private def sleep(duration: Long) {
    Thread.sleep(duration)
  }

}

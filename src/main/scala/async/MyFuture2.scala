package async

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Random, Success}

/**
 * Note that you may be tempted to therefore wrap your blocking code in Futures. This does not make it non-blocking,
 * it just means the blocking will happen in a different thread. You still need to make sure that the thread pool
 * that you are using has enough threads to handle the blocking.
 *
 * The default execution context runs your futures on daemon threads which doesn't stop the JVM from exiting.
 */


object MyFuture2 extends App {

  /**
   * Blocking Future
   */
  val f1 = Future {
    sleep(500)
    2
  }

  // this is blocking (blocking is bad)
  // wait for up to 1 second
  val result = Await.result(f1, 1 second)
  println(s"f1's result = $result")
  // keep the JVM running
  sleep(1000)

  /**
   * Return Future[T]
   * 1. Handle result using callback
   */
  def f2(x: Int): Future[Int] = Future {
    sleep(500)
    x + 2
  }

  f2(10).onComplete {
    case Success(result) => println(s"f2's result = $result")
    case Failure(e) => e.printStackTrace
  }

  // keep the JVM running
  sleep(1000)

  /**
   * 1. Handle result using callback
   *
   * A callback method is executed by some thread, some time after the future is completed. From the Scala Futures
   * documentation, "There is no guarantee that it will be called by the thread that completed the future or the
   * thread that created the callback."
   *
   * The order in which callbacks are executed is not guaranteed.
   *
   * onComplete, onSuccess, and onFailure have the result type Unit, so they can’t be chained. This design was
   * intentional, to avoid any suggestion that callbacks may be executed in a particular order.
   */
  val f3 = Future {
    sleep(Random.nextInt(500))
    2
  }

  f3.onComplete {
    case Success(value) => println(s"f3's result = $value")
    case Failure(e) => e.printStackTrace
  }

  println("A ...")
  sleep(100)
  println("B ...")
  sleep(100)
  println("C ...")
  sleep(100)
  println("D ...")
  sleep(100)
  println("E ...")
  sleep(100)
  println("F ...")
  sleep(100)

  // keep the JVM running
  //  sleep(2000)

  /**
   * 2. Handle result using map
   */

  /**
   * 3. Handle result using flatMap
   */

  def sleep(duration: Long) {
    Thread.sleep(duration)
  }

}

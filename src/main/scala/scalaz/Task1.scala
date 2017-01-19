package scalaz

import scalaz._, Scalaz._
import scalaz.concurrent.Task

/**
  * http://blog.higher-order.com/blog/2015/06/18/easy-performance-wins-with-scalaz/
  *
  * `Task[A]` is a `scalaz.concurrent.Future[Throwable \/ A]`, with some convenience functions for handling exceptions.
  * Its `Monad` and `Nondeterminism` instances are derived from `Future`.
  *
  * A Task simply adds error handling to the Future.
  * This means you can add your own error handling on top of Future when required.
  *
  * Every Future is basically some work that needs to be submitted to a thread pool.
  * When you call futureA.flatMap(a => futureB), both Future[A] and Future[B] need to be submitted to the thread pool,
  * even though they are not running concurrently and could theoretically run on the same thread.
  * This context switching takes a bit of time.
  *
  * With scalaz.concurrent.Task you have a bit more control over when you submit work to a thread pool and
  * when you actually want to continue on the thread that is already executing a Task.
  * When you say taskA.flatMap(a => taskB), the taskB will by default just continue running on the same thread
  * that was already executing taskA. If you explicitly want to dip into the thread pool,
  * you have to say so with Task.fork.
  */
object Task1 extends App {

  def performAction(num: Int): Unit =
    println(s"Task #$num is executing in ${Thread.currentThread().getName}")

  // Task.now method lifts a value to a Task by executing logic in the current thread
  val result2T = Task.now {
    performAction(2)
  }

  // Task.apply method schedules execution in a thread pool, and will not run until it’s manually started.
  val result3T = Task {
    performAction(3)
  }
  // * nothing happened *

  val result4T = Task.delay {
   performAction (4)
  }

}

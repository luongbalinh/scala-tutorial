package scalaz

import scalaz._, Scalaz._
import scalaz.concurrent.Task

/**
  * Task.now method lifts a value to a Task by executing logic in the current thread
  *
  * Task.apply method schedules execution in a thread pool, and will not run until it’s manually started.
  */
object Task1 extends App {

  def performAction(num: Int): Unit =
    println(s"Task #$num is executing in ${Thread.currentThread().getName}")

  val result2T = Task.now {
    performAction(2)
  }
  // Task #2 is executing in main

  val result3T = Task {
    performAction(3)
  }
  // * nothing happened *

  val result4T = Task.delay {
   performAction (4)
  }

}

package rxscala

import java.time.ZonedDateTime

import rx.lang.scala.Observable

import scala.concurrent.duration._
import scala.language.postfixOps
import rx.lang.scala._
import rx.lang.scala.schedulers._
import rx.observables.{AsyncOnSubscribe, SyncOnSubscribe}

/**
  * Observable is used to describe an asynchronous stream.
  *
  * Observable is something that you can subscribe to to listen for the items that the observable will emit.
  * They usually don't begin emitting items until you subscribe to them.
  *
  * Observers watch Observables by subscribing to them.
  * A instance of Subscription represents the connection between an observer and an observable.
  * Observers are notified when an Observable emits a value (onNext), says an error has occurred (onError), says no longer has any values to emit (onCompleted).
  *
  * All of these actions are going to be executed on the main thread.
  */
object Observable1 extends App {


  /**
    * Cold observables are observables which start producing values when subscribed.
    * Streams that are passive and start publishing on request.
    *
    * Hot observables are streams that are active and publish regardless of subscriptions.
    * The natural example is from UI programming: the stream of mouse clicks.
    * The clicks are produced regardless of whether or not the stream is subscribed to.
    */
  val o1 = Observable.just(1, 2, 3)
  o1.subscribe(
    n => println(n),
    e => e.printStackTrace(),
    () => println("done")
  )
  // When subscribed will get one event with current DateTime
  val o2 = Observable.defer {
    Observable.just(ZonedDateTime.now)
  }
  o2.subscribe(println(_))

  /**
    * You pass an Observer to an Observable's subscribe method (or a function literal)
    * The return type is Subscription, which is an object you call unsubscribe on to tell the Observable that
    * it should no longer invoke the Observer for that Subscription.
    */
//  val intObservable: Observable[Int] = Observable.just(1, 2, 3)
  //    val observer = Observer[Int](
  //      onNext = println(_),
  //      onError = e => println(e),
  //      onCompleted = () => println("all done")
  //    )
  //    val subscriptionObserver = intObservable.subscribe(observer)
//    val subscriptionFunLit = intObservable.subscribe(onNext = println(_))
}

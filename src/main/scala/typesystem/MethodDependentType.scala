package typesystem

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object MethodDependentType {
  def main(args: Array[String]) {

  }
}

//  Note that LocalResponse and RemoteResponse are unrelated.
case class LocalResponse(statusCode: Int)

case class RemoteResponse(message: String)

sealed trait Computation {
  type Response
  val work: Future[Response]
}

case class LocalComputation(work: Future[LocalResponse]) extends Computation {
  type Response = LocalResponse
}

case class RemoteComputation(work: Future[RemoteResponse]) extends Computation {
  type Response = RemoteResponse

  object Service {
    def handle(computation: Computation): computation.Response = {
      val duration = Duration(2, SECONDS)

      // Await waits for the future to complete.
      Await.result(computation.work, duration)
    }
  }

  Service.handle(LocalComputation(Future(LocalResponse(0))))
  // Result: LocalResponse = LocalResponse(0)
  Service.handle(RemoteComputation(Future(RemoteResponse("remote call"))))

  // Result: RemoteResponse = RemoteResponse(remote call)
}
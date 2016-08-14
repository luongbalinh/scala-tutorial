package async

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Future3 {
  val userFuture = Future(
    User("Me")
  )
  val userNameFuture: Future[String] = userFuture map {
    user => user.name
  }

  userNameFuture onSuccess {
    case userName => println(s"user's name =  $userName")
  }
}

case class User(name: String)

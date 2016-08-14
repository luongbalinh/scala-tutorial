import scala.concurrent.duration
import scala.concurrent.duration.Duration
import com.typesafe.config.ConfigFactory

object Solution extends App {
  val properties = ConfigFactory.load()
  val hatApiHost = properties.getString("PCS_HOST")
  println("HERE " + hatApiHost)
}
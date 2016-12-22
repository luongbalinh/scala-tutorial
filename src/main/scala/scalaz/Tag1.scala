package scalaz

/**
  * It uses the @@ symbol to "tag" an existing type as another type, i.e. create a new type
  */
sealed trait KiloGram

sealed trait JoulePerKiloGram

object Tag1 extends App {
  def KiloGram[A](a: A): A @@ KiloGram = Tag[A, KiloGram](a)

  def JoulePerKiloGram[A](a: A): A @@ JoulePerKiloGram = Tag[A, JoulePerKiloGram](a)

  def energy(m: Double @@ KiloGram): Double @@ JoulePerKiloGram =
    JoulePerKiloGram(299792458.0 * 299792458.0 * Tag.unwrap(m))

  val result: @@[Double, JoulePerKiloGram] = energy(KiloGram(20.0))
  //  energy(10.0) // ERROR
  println("debug point")
}


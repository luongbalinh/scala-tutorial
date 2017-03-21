package stream

/**
  * ((100 to 1000) filter isPrime)(1) returns the second prime number between 100 and 1000.
  * However, it constructs all prime number between 100 and 1000 -> NOT efficient.
  *
  * Streams are similar to Lists, but their tail is evaluated only on demand.
  *
  */
object Stream1 extends App {
  Stream(1, 2, 3)
  (1 to 10).toStream

  // infinite stream of all integers starting from n
  def from(n: Int): Stream[Int] = n #:: from(n + 1)

  // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
  def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter (_ % s.head != 0))

  val allPrimes: Stream[Int] = sieve(from(2))
}

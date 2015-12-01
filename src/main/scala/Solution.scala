

object Solution extends App {

  //  import FileHelper._

  //  implicit val file = "/Users/Luong/Documents/repos/templates/scala-tutorial/src/main/scala/input.txt"

  private def findMaxBorder(s: String): Option[String] = {
    val index = findMaxBorderIndex(s)
    if (index >= 0)
      Some(s.substring(0, index + 1))
    else
      None
  }

  private def findMaxBorderIndex(s: String): Int = {
    val length = s.length
    for (i <- 0 to length - 2) {
      if (s.charAt(i) != s.charAt(length - 1 - i))
        return i - 1
    }
    length - 2
  }

  private def isPalindrome(s: String): Boolean = {
    val length = s.length
    for (i <- 0 to (length - 1) / 2) {
      if (s.charAt(i) != s.charAt(length - 1 - i))
        return false
    }
    true
  }
}

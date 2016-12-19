package collection

/**
 * Created by Luong on 30/7/15.
 */
object Filter1 {
  def main(args: Array[String]) {
    val result = (1 to 100).filter(n => {
      n match {
        case 2 => true
        case 5 => true
        case _ => false
      }
    })

    println(result)

  }

}

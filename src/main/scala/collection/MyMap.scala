package collection

object MyMap {
  def main(args: Array[String]) {
    // generate a list by zipping two list. The longer list is truncated.
    val numberList = List(1, 2)
    val stringList = List("one", "two")
    val map = numberList.zip(stringList).toMap
    println(map)
  }

}

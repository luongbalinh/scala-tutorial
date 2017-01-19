package basic

/**
  * Existential types allow us to specify only the part of the type signature we care about and omit everything else.
  */
object ExistentialType extends App {

  def printContents(list: List[_]): Unit = list.foreach(println)
}

package collection

/**
  * The for comprehension syntax is actually syntactic sugar provided by the compiler for calling the collection
  * methods foreach, map, flatMap, and withFilter.
  *
  * <- is called generator operator. The left part of a generator ooperator is always a 'val'.
  * A new value of the val will be created for each iteration
  */
object Comprehension {
  def main(args: Array[String]) {
    printFruits
    println(extractFruitsCharacters)
    printFilteredFruits
    println(filterFruits)
    printOptionFruits1
    printOptionFruits2


    val values: List[Tuple2[Int, Boolean]] = List((1, false), (2, false), (3, false), (4, false))
    val result = for {
      value <- values
      if value._2
    } yield value
    println(result)
  }

  val fruits = List("apple", "oranges", "banana")

  // This comprehension only performs side effects, hence is called for loop.
  def printFruits = {
    println("\nAll fruits:")
    for (fruit <- fruits) {
      println(fruit)
    }
  }

  // When there are multiple generators, all but the last are converted to flatMap invocations. The last is a map
  // invocation, i.e. a List is generated.
  def extractFruitsCharacters = {
    println("\nAll fruits with flattern:")
    for {
      fruit <- fruits
      f <- fruit} yield f
  }

  // use if for filtering. Each if must be on a separate line.
  // Filtering expressions are called guards.
  // Best practice: use curly braces instead of parentheses for multiple filtering conditions.

  def printFilteredFruits = {
    println("\nAll fruits starting with b and contain a:")
    for {
      fruit <- fruits
      if fruit.contains("a") && fruit.startsWith("b")
    } {
      println(fruit)
    }

  }

  // for yield store resulting elements in a new collection.
  // the first expression has to be an generator operator, i.e. cannot use assign (=) operator.
  def filterFruits: List[String] = {
    println("\nPrinting filtered fruits:")
    for {
      fruit <- fruits
      if fruit.contains("a")
      capitalizedFruit = fruit.toUpperCase()
    } yield capitalizedFruit
  }

  // for comprehension can be used to filter out None
  val optionFruits = List(Some("apple"), None, Some("orange"))

  def printOptionFruits1 = {
    println("\nPrinting option fruits 1:")
    for {fruitOption <- optionFruits
         fruit <- fruitOption} {
      {
        println(fruit)
      }
    }

  }

  def printOptionFruits2 = {
    println("\nPrinting option fruits 2:")
    for (Some(fruit) <- optionFruits) {
      println(fruit)
    }

  }
}

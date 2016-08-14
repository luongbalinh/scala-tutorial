package utils

import org.scalatest._
import utils.CsvHelper._

class CsvHelperTest extends FlatSpec with ShouldMatchers with GivenWhenThen {
  "CsvHelper" should "be able to handle string without special characters" in {
    Given("a string without special characters")
    val s = "Hello"

    When("converting the string to CSV format")
    val result: String = escape(s)

    Then("it should return the same string")
    result should equal(s)
  }

  it should "be able to handle string with comma(,)" in {
    Given("a string with comma")
    val s = "Hello, world."

    When("converting the string to CSV format")
    val result: String = escape(s)

    Then("it should return the string wrapped in double quotes")
    result should equal("\"Hello, world.\"")
  }

  it should "be able to handle string with double quote (\")" in {
    Given("a string with double quote")
    val s = "\"World\""

    When("converting the string to CSV format")
    val result: String = escape(s)

    Then("it should return the string wrapped in double quotes")
    result should equal("\"\"\"World\"\"\"")
  }

  it should "be able to handle string with both comma and double quote" in {
    Given("a string with comma and double quote")
    val s = "Hello \",\" World"

    When("converting the string to CSV format")
    val result: String = escape(s)

    Then("it should return the string wrapped in double quotes")
    result should equal("\"Hello \"\",\"\" World\"")
  }
}

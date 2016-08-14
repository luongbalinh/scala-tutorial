package utils

object CsvHelper {

  def escape(s: String): String = {
    val replacedQuoteString = replaceQuote(s)
    handleEscapeCharacters(replacedQuoteString)
  }

  private def replaceQuote(s: String): String = {
    if (s.contains(Quote))
      s.replace(Quote, EscapedQuote)
    else
      s
  }

  private def handleEscapeCharacters(s: String): String = {
    if (CharactersMustBeQuoted exists s.contains)
      Quote + s + Quote
    else
      s

  }

  private val Quote: String = "\""
  private val EscapedQuote = "\"\""
  private val CharactersMustBeQuoted = List(",", "\"")

}

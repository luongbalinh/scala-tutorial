package utils

object CsvHelper {
  private val Quote: String = "\""
  private val EscapedQuote = "\"\""
  private val CharactersMustBeQuoted = List(",", "\"")

  def escape(s: String): String =
    handleEscapeCharacters(replaceQuote(s))

  private def replaceQuote(s: String): String =
    if (s.contains(Quote))
      s.replace(Quote, EscapedQuote)
    else
      s

  private def handleEscapeCharacters(s: String): String =
    if (CharactersMustBeQuoted exists s.contains)
      Quote + s + Quote
    else
      s
}

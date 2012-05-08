package modules

abstract class GuessResult() {
  def number: Int
  def message: String
}

case class WrongGuess(number: Int) extends GuessResult {
	def message = "you made a wrong guess, you will never get it right"
}

case class CorrectGuess(number: Int) extends GuessResult {
  def message = "yaaaaaay! Correct."
}

object GuessResult {
  def from(guess: Int, correctGuess: Int) = guess match {
    case n if n == correctGuess => CorrectGuess(n)
    case n                      => WrongGuess(n)
  }
}
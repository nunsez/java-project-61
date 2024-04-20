package hexlet.code

class PrimeGame : Game() {
    override fun rule(): String {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'."
    }

    override fun newRound(): GameRound {
        val number = (1..numberLimit).random()

        val question = question(number)
        val rightAnswer = rightAnswer(number)

        return GameRound(question, rightAnswer)
    }

    private fun question(number: Int): String {
        return "Question: $number"
    }

    private fun rightAnswer(number: Int): String {
        return if (isPrime(number)) "yes" else "no"
    }

    private fun isPrime(number: Int): Boolean {
        if (number < 2) return false

        val sqrt = Math.sqrt(number.toDouble()).toInt()

        return (2..sqrt).none { number % it == 0 }
    }

    companion object {
        private const val numberLimit = 47
    }
}

package hexlet.code

class EvenGame : Game() {
    override fun rule(): String {
        return "Answer 'yes' if the number is even, otherwise answer 'no'."
    }

    override fun newRound(): GameRound {
        val number = (1..numberLimit).random()
        return GameRound(question(number), rightAnswer(number))
    }

    private fun question(number: Int): String {
        return "Question: $number"
    }

    private fun rightAnswer(number: Int): String {
        return when {
            isEven(number) -> "yes"
            else -> "no"
        }
    }

    private fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    companion object {
        private const val numberLimit = 99
    }
}

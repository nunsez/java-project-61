package hexlet.code

class GcdGame : Game() {
    override fun rule(): String {
        return "Find the greatest common divisor of given numbers."
    }

    override fun newRound(): GameRound {
        val n1 = generateNumber()
        val n2 = generateNumber()

        val question = question(n1, n2)
        val rightAnswer = rightAnswer(n1, n2)

        return GameRound(question, rightAnswer)
    }

    private fun question(n1: Int, n2: Int): String {
        return "Question: $n1 $n2"
    }

    private fun rightAnswer(n1: Int, n2: Int): String {
        val result = gcd(n1, n2)
        return result.toString()
    }

    private fun gcd(n1: Int, n2: Int): Int {
        if (n2 == 0) return n1

        return gcd(n2, n1 % n2)
    }

    private fun generateNumber(): Int {
        // protect the game from answer '1'
        val gcdProtector = (1..numberLimit).random()

        return gcdProtector * (1..numberLimit).random()
    }

    companion object {
        private const val numberLimit = 10
    }
}

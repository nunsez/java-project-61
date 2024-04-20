package hexlet.code

class CalcGame : Game() {
    override fun rule(): String {
        return "What is the result of the expression?"
    }

    override fun newRound(): GameRound {
        val op = operations.random()
        val n1 = (1..numberLimit).random()
        val n2 = (1..numberLimit).random()

        val question = question(op, n1, n2)
        val rightAnswer = rightAnswer(op, n1, n2)

        return GameRound(question, rightAnswer)
    }

    private fun question(op: String, n1: Int, n2: Int): String {
        return "Question: $n1 $op $n2"
    }

    private fun rightAnswer(op: String, n1: Int, n2: Int): String {
        val result = calculate(op, n1, n2)
        return result.toString()
    }

    private fun calculate(op: String, n1: Int, n2: Int): Int? {
        return when (op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> n1 / n2
            else -> null
        }
    }

    companion object {
        private final val operations = arrayOf("+", "-", "*")

        private const val numberLimit = 49
    }
}

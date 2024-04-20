package hexlet.code

class ProgressionGame : Game() {
    override fun rule(): String {
        return "What number is missing in the progression?"
    }

    override fun newRound(): GameRound {
        @Suppress("MagicNumber")
        val start = (0..10).random()

        @Suppress("MagicNumber")
        val step = (1..5).random()

        val hiddenElementIndex = (0..(progressionLength - 1)).random()
        val progression = makeProgression(start, step, progressionLength)

        val rightAnswer = progression[hiddenElementIndex].toString()
        val question = question(progression, hiddenElementIndex)

        return GameRound(question, rightAnswer)
    }

    private fun question(progression: IntArray, hiddenElementIndex: Int): String {
        val progressionString = progression
            .mapIndexed { idx, el -> if (idx == hiddenElementIndex) ".." else el.toString() }
            .joinToString(" ")

        return "Question: $progressionString"
    }

    private fun makeProgression(start: Int, step: Int, length: Int): IntArray {
        return IntArray(length) { start + it * step }
    }

    companion object {
        private const val progressionLength = 10
    }
}

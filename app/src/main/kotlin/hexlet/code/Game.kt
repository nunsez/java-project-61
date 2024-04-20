package hexlet.code

abstract class Game {
    lateinit var player: Player
        private set

    companion object {
        final val validChoices = arrayOf("1,", "2", "3", "4", "5", "6")

        final val choices = """
        1 - Greet
        2 - Even
        3 - Calc
        4 - GCD
        5 - Progression
        6 - Prime
        """.trimIndent()

        fun init(choice: String): Game {
            val game = when (choice) {
                "1" -> GreetGame()
                "2" -> EvenGame()
                "3" -> CalcGame()
                "4" -> GcdGame()
                "5" -> ProgressionGame()
                "6" -> PrimeGame()
                else -> throw IllegalArgumentException("Invalid choice: $choice")
            }

            println("Welcome to the Brain Games!")
            game.player = Player.fromCli()

            return game
        }
    }

    abstract fun rule(): String

    abstract fun newRound(): GameRound

    open fun rounds(): Int = 3

    open fun run(runner: GameRunner) {
        runner.runGame(this)
    }
}

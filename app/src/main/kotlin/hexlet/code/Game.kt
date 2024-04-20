package hexlet.code

abstract class Game {
    lateinit var player: Player
        private set

    companion object {
        final val validChoices = arrayOf("1,", "2")

        final val choices = """
        1 - Greet
        2 - Even
        """.trimIndent()

        fun init(choice: String): Game {
            val game = when (choice) {
                "1" -> GreetGame()
                "2" -> EvenGame()
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

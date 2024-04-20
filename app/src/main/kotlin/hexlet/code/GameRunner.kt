package hexlet.code

class GameRunner {
    fun runGame(game: Game) {
        val rounds = game.rounds()
        var round = 1

        println(game.rule())

        while (round <= rounds) {
            val gameRound = game.newRound()
            val isPlayerWin = runRound(gameRound)

            if (!isPlayerWin) {
                println("Let's try again, ${game.player.name}!")
                return
            }

            round += 1
        }

        println("Congratulations, ${game.player.name}!")
    }

    private fun runRound(round: GameRound): Boolean {
        println(round.question)

        val playerAnswer = readln()
        val rightAnswer = round.rightAnswer

        if (playerAnswer == rightAnswer) {
            println("Correct!")
            return true
        } else {
            println("\"$playerAnswer\" is wrong answer ;(. Correct answer was \"$rightAnswer\"")
            return false
        }
    }

    companion object {
        fun start() {
            val choice = askChoice()
            if (choice == "0") return

            var game: Game

            try {
                game = Game.init(choice)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                return
            }

            println("Your choice: $choice\n")
            game.run(GameRunner())
        }

        private fun askChoice(): String {
            println("Please enter the game number and press Enter.")
            printChoices()
            return readln()
        }

        private fun printChoices() {
            println(Game.choices)
            println("0 - Exit")
        }
    }
}

package hexlet.code

class GreetGame : Game() {
    override fun rule(): String {
        throw NotImplementedError("GreetGame does not have rule")
    }

    override fun newRound(): GameRound {
        throw NotImplementedError("GreetGame can not start round")
    }

    override fun run(runner: GameRunner) {
        // do nothing
    }
}

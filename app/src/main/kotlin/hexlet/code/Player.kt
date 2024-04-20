package hexlet.code

class Player(val name: String) {
    companion object {
        fun fromCli(): Player {
            println("May I have your name?")
            val name = readln()
            return Player(name)
        }
    }
}

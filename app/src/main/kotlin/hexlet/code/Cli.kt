package hexlet.code

class Cli {
    companion object {
        fun greet() {
            println("May I have your name?")
            val name = readln()
            println("Hello, $name!")
        }
    }
}

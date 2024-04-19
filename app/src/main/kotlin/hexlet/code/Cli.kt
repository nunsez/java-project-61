package hexlet.code

object Cli {
    fun greet() {
        println("May I have your name?")
        val name = readln()
        println("Hello, $name!")
    }
}

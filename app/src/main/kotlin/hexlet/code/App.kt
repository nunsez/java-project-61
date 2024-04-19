package hexlet.code

class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Welcome to the Brain Games!")
            Cli.greet()
        }
    }
}

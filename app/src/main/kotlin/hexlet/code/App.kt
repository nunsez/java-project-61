package hexlet.code

@Suppress("UtilityClassWithPublicConstructor")
class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GameRunner.start()
        }
    }
}

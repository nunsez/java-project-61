package hexlet.code.games;

import java.util.Random;

public final class PrimeGame extends AbstractGame {

    private static final int MAX_NUMBER = 47;

    public String getRule() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public GameRound getNewRound() {
        var rand = new Random();
        var number = rand.nextInt(1, MAX_NUMBER + 1);
        var task = Integer.toString(number);

        return new GameRound(
                task,
                prepareAnswer(number)
        );
    }

    private String prepareAnswer(int number) {
        return isPrime(number) ? "yes" : "no";
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        var sqrt = Math.sqrt(number);

        for (var i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

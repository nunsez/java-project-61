package hexlet.code.games;

import java.util.Random;

public final class GcdGame extends Game {

    private static final int MAX_NUMBER = 10;

    private static int generateNumber() {
        var random = new Random();
        var gcdProtector = random.nextInt(1, MAX_NUMBER + 1);
        return gcdProtector * random.nextInt(1, MAX_NUMBER + 1);
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }

        return gcd(num2, num1 % num2);
    }

    @Override
    public String getRule() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    public GameRound getNewRound() {
        var num1 = generateNumber();
        var num2 = generateNumber();

        var task = "%d %d".formatted(num1, num2);
        var rightAnswer = Integer.toString(gcd(num1, num2));

        return new GameRound(task, rightAnswer);
    }
}

package hexlet.code.games;

import java.util.Random;

public final class CalcGame extends AbstractGame {

    private static final int MAX_NUMBER = 49;

    public String getRule() {
        return "What is the result of the expression?";
    }

    public GameRound getNewRound() {
        var random = new Random();

        var op = OPS.getRandom();
        var num1 = random.nextInt(1, MAX_NUMBER + 1);
        var num2 = random.nextInt(1, MAX_NUMBER + 1);

        var task = "%d %s %d".formatted(num1, op, num2);
        var calcResult = op.calc(num1, num2);
        var rightAnswer = Integer.toString(calcResult);

        return new GameRound(task, rightAnswer);
    }
}

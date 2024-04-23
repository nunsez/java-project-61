package hexlet.code.games;

import java.util.Random;

public class EvenGame extends Game {

    private static final int MAX_NUMBER = 99;

    @Override
    public String getRule() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    public GameRound getNewRound() {
        var number = new Random().nextInt(1, MAX_NUMBER + 1);

        return new GameRound(
                Integer.toString(number),
                rightAnswer(number)
        );
    }

    private String rightAnswer(int number) {
        return isEven(number) ? "yes" : "no";
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}

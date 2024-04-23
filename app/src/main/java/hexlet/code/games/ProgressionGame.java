package hexlet.code.games;

import java.util.Random;
import java.util.StringJoiner;

public final class ProgressionGame extends AbstractGame {

    private static final int PROGRESSION_LENGTH = 10;

    private static final int MAX_START = 10;

    private static final int MAX_STEP = 10;

    private static int[] mageProgression(int start, int step) {
        var progression = new int[PROGRESSION_LENGTH];

        for (var i = 0; i < progression.length; i++) {
            progression[i] = start + i * step;
        }

        return progression;
    }

    public String getRule() {
        return "What number is missing in the progression?";
    }

    public GameRound getNewRound() {
        var random = new Random();
        var start = random.nextInt(1, MAX_START + 1);
        var step = random.nextInt(1, MAX_STEP + 1);
        var hiddenIdx = random.nextInt(PROGRESSION_LENGTH);

        var progression = mageProgression(start, step);
        var rightAnswer = Integer.toString(progression[hiddenIdx]);

        return new GameRound(
                prepareTask(progression, hiddenIdx),
                rightAnswer
        );
    }

    private String prepareTask(int[] progression, int hiddenIdx) {
        var task = new StringJoiner(" ");

        for (var i = 0; i < progression.length; i++) {
            if (i == hiddenIdx) {
                task.add("..");
            } else {
                var current = progression[i];
                task.add(Integer.toString(current));
            }
        }

        return task.toString();
    }
}

package hexlet.code.games;

public final class GameRound {

    private final String task;
    private final String rightAnswer;

    GameRound(String taskValue, String rightAnswerValue) {
        this.task = taskValue;
        this.rightAnswer = rightAnswerValue;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getTask() {
        return task;
    }
}

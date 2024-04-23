package hexlet.code.games;

public final class GameRound {

    private final String task;
    private final String rightAnswer;

    GameRound(String task, String rightAnswer) {
        this.task = task;
        this.rightAnswer = rightAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getTask() {
        return task;
    }
}

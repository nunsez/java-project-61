package hexlet.code.games;

import hexlet.code.GameEngine;

public final class GreetGame extends AbstractGame {

    public String getRule() {
        throw new IllegalCallerException("GreetGame can not start round");
    }

    public GameRound getNewRound() {
        throw new IllegalCallerException("GreetGame can not start round");
    }

    public void run(GameEngine runner) {
        // do nothing
    }
}

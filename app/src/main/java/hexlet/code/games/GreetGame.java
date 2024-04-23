package hexlet.code.games;

import hexlet.code.GameEngine;

public class GreetGame extends Game {

    @Override
    public String getRule() {
        throw new IllegalCallerException("GreetGame can not start round");
    }

    @Override
    public GameRound getNewRound() {
        throw new IllegalCallerException("GreetGame can not start round");
    }

    @Override
    public void run(GameEngine runner) {
        // do nothing
    }
}

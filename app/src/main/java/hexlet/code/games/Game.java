package hexlet.code.games;

import hexlet.code.Player;
import hexlet.code.GameEngine;

public abstract class Game {

    private static final int DEFAULT_ROUNDS = 3;

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public abstract String getRule();

    public abstract GameRound getNewRound();

    public int getRounds() {
        return DEFAULT_ROUNDS;
    }

    public void run(GameEngine engine) {
        engine.runGame(this);
    }
}

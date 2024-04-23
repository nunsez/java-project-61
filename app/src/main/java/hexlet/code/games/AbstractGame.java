package hexlet.code.games;

import hexlet.code.GameEngine;
import hexlet.code.Player;

abstract class AbstractGame implements Game {

    private static final int DEFAULT_ROUNDS = 3;

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player playerValue) {
        this.player = playerValue;
    }

    public int getRounds() {
        return DEFAULT_ROUNDS;
    }

    public void run(GameEngine engine) {
        engine.runGame(this);
    }
}

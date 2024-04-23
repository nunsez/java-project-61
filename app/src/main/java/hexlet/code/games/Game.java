package hexlet.code.games;

import hexlet.code.Player;
import hexlet.code.GameEngine;

public interface Game {
    Player getPlayer();

    void setPlayer(Player player);

    String getRule();

    GameRound getNewRound();

    int getRounds();

    void run(GameEngine engine);
}

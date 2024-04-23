package hexlet.code;

import java.util.Scanner;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.Game;
import hexlet.code.games.GameRound;
import hexlet.code.games.GcdGame;
import hexlet.code.games.GreetGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;

public class GameEngine {

    public static final String CHOICES = """
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit\
            """;

    public static void start() {
        final var choice = askChoice();

        if (choice.equals("0")) {
            return;
        }

        Game game;

        try {
            game = initGame(choice);
        } catch (InvalidChoiceException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.printf("Your choice: %s\n\n", choice);
        var player = greet();

        game.setPlayer(player);
        game.run(new GameEngine());
    }

    public static Player greet() {
        System.out.println("Welcome to the Brain Games!");
        var player = Player.fromCli();
        System.out.printf("Hello %s!\n", player.getName());

        return player;
    }

    private static Game initGame(String choice) throws InvalidChoiceException {
        return switch (choice) {
            case "1" -> new GreetGame();
            case "2" -> new EvenGame();
            case "3" -> new CalcGame();
            case "4" -> new GcdGame();
            case "5" -> new ProgressionGame();
            case "6" -> new PrimeGame();
            default ->  throw InvalidChoiceException.fromChoice(choice);
        };
    }

    private static String askChoice() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(CHOICES);
        return new Scanner(System.in).nextLine();
    }

    public void runGame(Game game) {
        System.out.println(game.getRule());
        var playerName = game.getPlayer().getName();

        for (var round = 0; round < game.getRounds(); round++) {
            var gameRound = game.getNewRound();
            var isPlayerWin = runRound(gameRound);

            if (!isPlayerWin) {
                System.out.printf("Let's try again, %s!\n", playerName);
                return;
            }
        }

        System.out.printf("Congratulations, %s!\n", playerName);
    }

    private boolean runRound(GameRound round) {
        var question = "Question: %s".formatted(round.getTask());
        System.out.println(question);

        var playerAnswer = new Scanner(System.in).nextLine();
        var rightAnswer = round.getRightAnswer();

        if (playerAnswer.equals(rightAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf(
                    "'%s' is wrong answer ;(. Correct answer was '%s'\n",
                    playerAnswer,
                    rightAnswer
            );
            return false;
        }
    }
}

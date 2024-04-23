package hexlet.code;

import java.util.Scanner;

public final class Player {
    private final String name;

    Player(String name) {
        this.name = name;
    }

    public static Player fromCli() {
        System.out.println("May I have your name?");
        var name = new Scanner(System.in).nextLine();
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}

package hexlet.code.games;

import java.util.Random;

enum OPS {
    PLUS("+") {
        @Override
        int calc(int num1, int num2) {
            return num1 + num2;
        }
    },
    MINUS("-") {
        @Override
        int calc(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*") {
        @Override
        int calc(int num1, int num2) {
            return num1 * num2;
        }
    };

    private final String op;

    public static OPS getRandom() {
        var random = new Random();
        var randomIndex = random.nextInt(OPS.values().length);
        return OPS.values()[randomIndex];
    }

    OPS(String op) {
        this.op = op;
    }

    int calc(int num1, int num2) {
        return 0;
    }

    @Override
    public String toString() {
        return op;
    }
}

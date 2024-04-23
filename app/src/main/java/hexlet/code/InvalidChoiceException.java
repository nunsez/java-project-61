package hexlet.code;

public final class InvalidChoiceException extends IllegalArgumentException {
    public static IllegalArgumentException fromChoice(String choice) {
        var message = "Invalid choice: %s".formatted(choice);
        return new IllegalArgumentException(message);
    }
}

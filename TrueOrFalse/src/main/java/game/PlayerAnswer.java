package game;

import java.util.Scanner;

public class PlayerAnswer {

    private final Scanner scanner = new Scanner(System.in);
    public boolean getBooleanInput() {
            return scanner.nextBoolean();
    }

    public boolean getPlayerAnswer() {
        try {
            return getBooleanInput();
        } catch (Exception e) {
            System.out.println("Invalid input, defaulting to false");
            return false;
        }
    }
}

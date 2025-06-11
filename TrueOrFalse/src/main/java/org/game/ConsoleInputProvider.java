package org.game;

import java.util.Scanner;

public class ConsoleInputProvider implements InputProvider {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public boolean getBooleanInput() {
        return scanner.nextBoolean();
    }
}

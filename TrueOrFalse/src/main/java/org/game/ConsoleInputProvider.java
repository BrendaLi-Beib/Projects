package org.game;

import java.util.Scanner;

public class ConsoleInputProvider{
    private final Scanner scanner = new Scanner(System.in);

    public boolean getBooleanInput() {
        return scanner.nextBoolean();
    }
}

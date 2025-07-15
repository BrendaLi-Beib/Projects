package org.game;

import java.util.Scanner;

<<<<<<< HEAD
public class ConsoleInputProvider{
    private final Scanner scanner = new Scanner(System.in);

=======
public class ConsoleInputProvider implements InputProvider {
    private final Scanner scanner = new Scanner(System.in);
    @Override
>>>>>>> 1b44c770febab0a94e460cdc8910cc8d867e4bc0
    public boolean getBooleanInput() {
        return scanner.nextBoolean();
    }
}

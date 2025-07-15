package org;


import org.game.ConsoleInputProvider;
import org.game.Game;
import org.game.Player;
import org.game.QuestionBank;


public class App
{
    public static void main( String[] args )
    {
        Player player = new Player("Brenda");
        ConsoleInputProvider console = new ConsoleInputProvider();
        QuestionBank questions = new QuestionBank();
        Game game = new Game(player, console, questions);
        System.out.println("Welcome to True or False, " + player.getName() + "!");
        game.start();
    }
}
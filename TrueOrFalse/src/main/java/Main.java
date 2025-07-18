import game.PlayerAnswer;
import game.Game;
import game.Player;
import game.QuestionBank;


public class Main
{
    public static void main( String[] args )
    {
        Player player = new Player("Brenda");
        PlayerAnswer console = new PlayerAnswer();
        QuestionBank questions = new QuestionBank();
        Game game = new Game(player, console, questions);

        System.out.println("Welcome to True or False, " + player.getName() + "!");
        game.start();
    }
}
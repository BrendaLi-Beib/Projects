package game;


public class Game {
    private final Player player;
    private final QuestionBank questionBank;
    private final PlayerAnswer playerAnswer;
    private boolean gameOver;

    public Game(Player player, PlayerAnswer playerAnswer, QuestionBank questionBank) {
        this.player = player;
        this.questionBank = questionBank;
        this.playerAnswer = playerAnswer;
        this.gameOver = false;
    }
    public boolean checkGameStatus(){
        if(player.getScore()<0){
            System.out.println("You lost!");
            this.gameOver = true;
        }
        return gameOver;
    }

    public void start() {
        do {
            System.out.println("You have 5 questions to answer.");
            round();
            if(checkGameStatus()) break;

            System.out.println("Do you want to play again? (true/false) ");
            gameOver = !playerAnswer.getPlayerAnswer();

        }while (!gameOver);
        System.out.println("Game over! Thanks for playing!");
    }


    private void round() {

        for (int i = 0; i < 5; i++) {
            System.out.print("Question " + (i + 1) + ": ");
            askQuestion();
        }
        System.out.println("Your score is: " + player.getScore() + "");
    }
    public void askQuestion() {
        Question question = questionBank.getRandmQuestion();
        System.out.println(question.getQuestion());
        System.out.println("Press 'true' or 'false': ");

        boolean playerAnswer = this.playerAnswer.getPlayerAnswer();

        if (question.isCorrectAnswer(playerAnswer)) {
            System.out.println("Correct! ✅");
            player.addPoint();
        } else {
            System.out.println("Wrong! ❌");
            player.removePoint();
        }
    }
}

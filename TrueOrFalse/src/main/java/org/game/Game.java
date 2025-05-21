package org.game;

import java.util.List;

public class Game {
    private final Player player;
    private final QuestionBank questionBank;
    private final ConsoleInputProvider consoleInputProvider;
    private boolean gameOver;

    public Game(Player player, ConsoleInputProvider consoleInputProvider, QuestionBank questionBank) {
        this.player = player;
        this.questionBank = questionBank;
        this.consoleInputProvider = consoleInputProvider;
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
            gameOver = !getPlayerAnswer();

        }while (!gameOver);
        System.out.println("Game over! Thanks for playing!");
    }

    public boolean getPlayerAnswer() {
        try {
            return consoleInputProvider.getBooleanInput();
        } catch (Exception e) {
            System.out.println("Invalid input, defaulting to false");
            return false;
        }
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
        System.out.println(question.getText());
        System.out.println("Press 'true' or 'false': ");

        boolean playerAnswer = getPlayerAnswer();

        if (question.isCorrectAnswer(playerAnswer)) {
            System.out.println("Correct! ✅");
            player.addPoint();
        } else {
            System.out.println("Wrong! ❌");
            player.removePoint();
        }
    }
}

package game;

public class Question {
    final private String question;
    final private boolean answer;


    public Question(String text, boolean answer) {
        this.question = text;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }
    public boolean isCorrectAnswer(boolean userAnswer) {
        return userAnswer == answer;
    }
}

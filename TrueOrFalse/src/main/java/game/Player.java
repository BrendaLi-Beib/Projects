package game;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    
    public void addPoint() {
        score++;
    }
    public void removePoint() {
        score--;
    }
    
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}

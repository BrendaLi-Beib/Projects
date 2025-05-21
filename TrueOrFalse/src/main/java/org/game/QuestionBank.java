package org.game;

import java.util.List;

public class QuestionBank {
    private List<Question> questions;

    public QuestionBank(){
        this.questions = DatabaseConn.getData();
    }
    public Question getRandmQuestion() {
        return questions.get((int)(Math.random() * questions.size()));
    }

}

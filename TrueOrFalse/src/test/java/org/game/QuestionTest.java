package org.game;

import game.Question;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    @Test
    void testCorrectAnswer() {
        Question q = new Question("Java is a programming language.", true);
        assertTrue(q.isCorrectAnswer(true));
        assertFalse(q.isCorrectAnswer(false));
    }
}

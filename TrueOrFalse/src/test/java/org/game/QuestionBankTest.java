package org.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionBankTest {

    @Test
    void testGetRandmQuestion() {

        QuestionBank qb = new QuestionBank();
        assertNotNull(qb.getRandmQuestion());
    }
}

package org.game;


import game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {
    Player player;
    QuestionBank questionBank ;
    PlayerAnswer playerAnswer;
    Game game = new Game(player, playerAnswer, questionBank);

    @BeforeEach
    void setUp() {
        player = mock(Player.class);
        questionBank = Mockito.mock(QuestionBank.class);
        playerAnswer = Mockito.mock(PlayerAnswer.class);
        game = new Game(player, playerAnswer, questionBank);

    }
    @Test
    void testCheckGameStatus_Lose() {
        when(player.getScore()).thenReturn(-1);
        assertTrue(game.checkGameStatus());
    }

    @Test
    void testAskQuestion_Correct(){
        Question question = mock(Question.class);
        when(question.getQuestion()).thenReturn("Question true or false?");
        when(questionBank.getRandmQuestion()).thenReturn(question);
        when(question.isCorrectAnswer(true)).thenReturn(true);
        when(playerAnswer.getBooleanInput()).thenReturn(true);

        game.askQuestion();

        verify(player).addPoint();
    }

    @Test
    void TestAskQuestion_Wrong(){
        Question question = mock(Question.class);
        when(questionBank.getRandmQuestion()).thenReturn(question);
        when(question.isCorrectAnswer(false)).thenReturn(false);
        when(playerAnswer.getBooleanInput()).thenReturn(false);

        game.askQuestion();

        verify(player).removePoint();
    }


}

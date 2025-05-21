package org.game;


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
    ConsoleInputProvider consoleInputProvider ;
    Game game = new Game(player, consoleInputProvider, questionBank);

    @BeforeEach
    void setUp() {
        player = mock(Player.class);
        questionBank = Mockito.mock(QuestionBank.class);
        consoleInputProvider = Mockito.mock(ConsoleInputProvider.class);
        game = new Game(player, consoleInputProvider, questionBank);

    }
    @Test
    void testCheckGameStatus_Lose() {
        when(player.getScore()).thenReturn(-1);
        assertTrue(game.checkGameStatus());
    }
    @Test
    void testGetPlayerAnswer_true() {
        when(consoleInputProvider.getBooleanInput()).thenReturn(true);
        assertTrue(game.getPlayerAnswer());
    }
    @Test
    void testGetPlayerAnswer_false() {
        when(consoleInputProvider.getBooleanInput()).thenReturn(false);
        assertFalse(game.getPlayerAnswer());
    }
    @Test
    void testAskQuestion_Correct(){
        Question question = mock(Question.class);
        when(question.getText()).thenReturn("Question true or false?");
        when(questionBank.getRandmQuestion()).thenReturn(question);
        when(question.isCorrectAnswer(true)).thenReturn(true);
        when(consoleInputProvider.getBooleanInput()).thenReturn(true);

        game.askQuestion();

        verify(player).addPoint();
    }

    @Test
    void TestAskQuestion_Wrong(){
        Question question = mock(Question.class);
        when(questionBank.getRandmQuestion()).thenReturn(question);
        when(question.isCorrectAnswer(false)).thenReturn(false);
        when(consoleInputProvider.getBooleanInput()).thenReturn(false);

        game.askQuestion();

        verify(player).removePoint();
    }


}

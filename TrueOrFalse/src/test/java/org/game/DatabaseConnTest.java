package org.game;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import java.sql.*;
import java.util.List;

public class DatabaseConnTest {
    Connection conn ;
    PreparedStatement stmt ;
    ResultSet rs;

    @BeforeEach
    void setUp() throws Exception {
        conn = mock(Connection.class);
        stmt = mock(PreparedStatement.class);
        rs = mock(ResultSet.class);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
    }

    @Test
    void testGetData() throws Exception {

        when(rs.next()).thenReturn(true, true, false);
        when(rs.getString("text")).thenReturn("Is Java fun?", "Is Python better?");
        when(rs.getBoolean("answer")).thenReturn(true, false);

        try (MockedStatic<DriverManager> mockedDriverManager = mockStatic(DriverManager.class)) {
            mockedDriverManager.when(() -> DriverManager.getConnection(anyString(), anyString(), anyString())).thenReturn(conn);

            List<Question> questions = DatabaseConn.getData();

            assertEquals(2, questions.size());
            assertEquals("Is Java fun?", questions.get(0).getText());
            assertTrue(questions.get(0).isCorrectAnswer(true));
        }
    }
}
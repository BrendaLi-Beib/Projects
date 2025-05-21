package org.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    void testAddPoint() {
        Player p = new Player("Brenda");
        assertEquals(0, p.getScore());
        p.addPoint();
        assertEquals(1, p.getScore());
    }

    @Test
    void testRemovePoint() {
        Player p = new Player("Brenda");
        assertEquals(0, p.getScore());
        p.removePoint();
        assertEquals(-1, p.getScore());
    }

    @Test
    void testGetName() {
        Player p = new Player("Brenda");
        assertEquals("Brenda", p.getName());
    }
    @Test
    void testGetScore() {
        Player p = new Player("Brenda");
        assertEquals(0, p.getScore());
    }

}

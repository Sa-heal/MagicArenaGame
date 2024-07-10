package com.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class ArenaTest {

    @Test
    public void testDetermineFirstAttacker() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);
        Arena arena = new Arena(player1, player2);

        Player firstAttacker = arena.determineFirstAttacker();
        assertEquals(player1, firstAttacker);

        player1 = new Player(100, 5, 10);
        player2 = new Player(50, 10, 5);
        arena = new Arena(player1, player2);
        firstAttacker = arena.determineFirstAttacker();
        assertEquals(player2, firstAttacker);
    }
}


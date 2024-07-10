package com.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void testIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());

        player.takeDamage(50);
        assertFalse(player.isAlive());
    }

    @Test
    public void testTakeDamage() {
        Player player = new Player(50, 5, 10);
        player.takeDamage(20);
        assertEquals(30, player.getHealth());
    }

    @Test
    public void testRollAttackDice() {
        Player player = new Player(50, 5, 10);
        int roll = player.rollAttackDice();
        assertTrue(roll >= 1 && roll <= 6);
    }

    @Test
    public void testRollDefendDice() {
        Player player = new Player(50, 5, 10);
        int roll = player.rollDefendDice();
        assertTrue(roll >= 1 && roll <= 6);
    }
}


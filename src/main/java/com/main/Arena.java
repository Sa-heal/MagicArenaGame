package com.main;

public class Arena {
    private Player player1;
    private Player player2;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startMatch() {
        Player attacker = determineFirstAttacker();
        Player defender = (attacker == player1) ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            fightRound(attacker, defender);
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (!player1.isAlive()) {
            System.out.println("Player 1 is dead. Player 2 wins!");
        } else {
            System.out.println("Player 2 is dead. Player 1 wins!");
        }
    }

    private void fightRound(Player attacker, Player defender) {
        int attackRoll = attacker.rollAttackDice();
        int defendRoll = defender.rollDefendDice();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendStrength = defender.getStrength() * defendRoll;

        int damageDealt = Math.max(0, attackDamage - defendStrength);
        defender.takeDamage(damageDealt);

        System.out.println("Attacker rolled: " + attackRoll);
        System.out.println("Defender rolled: " + defendRoll);
        System.out.println("Damage dealt: " + damageDealt);
        System.out.println("Defender health: " + defender.getHealth());
    }

    Player determineFirstAttacker() {
        if (player1.getHealth() < player2.getHealth()) {
            return player1;
        } else if (player1.getHealth() > player2.getHealth()) {
            return player2;
        } else {
            return (Math.random() < 0.5) ? player1 : player2;
        }
    }
}


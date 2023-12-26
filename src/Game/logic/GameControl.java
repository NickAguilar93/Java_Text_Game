package Game.logic;

import Game.domain.PlayableCharacter;
import Game.domain.NPC;

import java.util.Random;

public class GameControl {
    private PlayableCharacter player;

    private NPC currentEnemy;

    public GameControl() {

    }

    public void addCharacter(String name) {
        this.player = new PlayableCharacter(name,10,10,10,10,10,10);

    }

    public void generateNPC(int npcID) {
        Random rand = new Random();
        String npcName = "";
        int npcHP = rand.nextInt(6,10) + (2 * player.level);
        int npcMana = rand.nextInt(8,14) + (2 * player.level) ;
        int npcAttack = rand.nextInt(2,8) + (2 * player.level);
        int npcSAttack = rand.nextInt(2,8) +(2 * player.level);
        int npcDefense = rand.nextInt(2,8) + (2 * player.level);
        int npcSDefense = rand.nextInt(2,8) +(2 * player.level);

        switch (rand.nextInt(0,4)) {
            case 0 -> npcName = "Orc";
            case 1 -> npcName = "goblin";
            case 2 -> npcName = "Ghoul";
            case 3 -> npcName = "ogre";
        }
        currentEnemy = new NPC(npcName,npcHP,npcMana,npcAttack,npcSAttack,npcDefense,npcSDefense);

        System.out.println("A wild " + currentEnemy.name + " has appear out of nowhere, WOW!");

    }

    public boolean fight(Integer playerFightCommand) {


        //Player action phase
        if (playerFightCommand == 1) {
            this.currentEnemy.takeDamage(this.player.name, this.player.attackStat, playerFightCommand);
        } else if (playerFightCommand == 2) {
            //Does the player have enough mana
            if (this.player.manaCheck(2)) {
                this.currentEnemy.takeDamage(this.player.name, this.player.sAttackStat, playerFightCommand);
                this.player.subMana(2);
            } else {
                System.out.println("You do not have enough mana");
            }
        } else if (playerFightCommand == 3) {
                if (this.player.manaCheck(2)) {
                    this.player.heal(8);
                    this.player.subMana(2);
                } else {
                    System.out.println("You do not have enough mana");
                }
        } else if (playerFightCommand == 4) {
            System.out.println("You use a potion");
            this.player.heal(10);
        }

        if (fightOver()) {
            this.player.resetPlayer();
            this.player.increaseXP();
            this.player.xpToString();
            return true;
        }
        //Enemy Attack phase
        int enemyFightCommand  = 1;
        if (currentEnemy.mana >= 2) {
            enemyFightCommand = new Random().nextInt(1, 3);
        }

        if (enemyFightCommand == 1) {
            this.player.takeDamage(this.currentEnemy.name, this.currentEnemy.attackStat,enemyFightCommand);
        } else if(enemyFightCommand == 2) {
            this.player.takeDamage(this.currentEnemy.name, this.currentEnemy.sAttackStat,enemyFightCommand);
            this.player.subMana(2);
        }

        if (fightOver()) {
            return true;
        }

        System.out.println("Player HP: " + this.player.hpToString());
        System.out.println("Player mana: " + this.player.manaToString() + "\n");
        System.out.println("Enemy HP: " + this.currentEnemy.hpToString());
        System.out.println("Enemy mana: " + this.currentEnemy.manaToString());

        return false;
    }


    public boolean fightOver() {
        if (this.player.currentHP == 0) {
            System.out.println("Wasted!");
            System.out.println("YOU LOSE!");
            return true;
        } else if (this.currentEnemy.currentHP == 0) {
            System.out.println("\n" + "You defeated " + this.currentEnemy.name + " you win!");
            return true;
        } else {
            return false;
        }
    }

    public boolean gameOver() {
        if (this.player.currentHP == 0) {
            System.out.println("Game Over");
            return true;
        } else {
            return false;
        }
    }

    public void getPlayerXP() {
        this.player.xpToString();
    }

    public void getPlayerStats() {
        this.player.getPlayerStats();
    }
}

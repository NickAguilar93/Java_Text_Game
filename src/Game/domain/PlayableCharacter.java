package Game.domain;

import Game.logic.CharacterLogic;

public class PlayableCharacter extends CharacterLogic implements Interface{
    private int totalXP;
    private int maxXP;



    public PlayableCharacter(String name, int HP, int mana , int attack, int sAttack, int defense, int sDefense) {
        super(name ,HP,mana,attack,sAttack,defense,sDefense);
        this.maxXP = 2;
        this.totalXP = 0;

    }

    public void getPlayerStats() {
        System.out.println("Current Level: " + super.level);
        System.out.println("XP Required: " + this.maxXP);
        System.out.println("Player HP: " + super.hpToString());
        System.out.println("Player Mana: " + super.manaToString());
        System.out.println("Attack Stat: " + super.attackStat);
        System.out.println("Special Attack Stat: " + super.sAttackStat);
        System.out.println("Defense Stat: " + super.defenseStat);
        System.out.println("Special Defense Stat: " + super.sDefenseStat);
    }

    public void resetPlayer() {
        super.currentHP = super.maxHP;
        super.mana = super.maxMana;
    }

    public void increaseXP() {
        this.totalXP += this.level + 10 / 7;

        if(this.totalXP >= this.maxXP) {
            levelUP();
        }
    }

    public void levelUP() {

        super.level++;
        this.maxXP = super.level * super.level * super.level;
        super.maxHP += 2;
        super.maxMana += 2;
        super.attackStat += 2;
        super.sAttackStat += 2;
        super.defenseStat += 2;
        super.defenseStat += 2;
        System.out.println("LEVEL UP!" + "\n");
        getPlayerStats();
    }

    public void xpToString() {
        int remainingXP = this.maxXP - this.totalXP;
        System.out.println("\n" + this.totalXP + " Total XP");
        System.out.println(remainingXP + "XP to the next level");
    }

    public String toString() {
        return "s";
    }






}

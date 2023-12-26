package Game.logic;

import Game.domain.Character;

public class CharacterLogic extends Character {

    public CharacterLogic(String name, int HP, int mana , int attack, int sAttack, int defense, int sDefense) {
        super(name,HP,mana,attack,sAttack,defense,sDefense);
    }

    public void takeDamage(String attackerName, double attackValue, int attackType) {
        double levelDamage = ((2 * (double) super.level) / 5) + 2;
        double defenseStat = 0;

        if (attackType == 1) { //Physical Attack
            System.out.println(attackerName + " swings their weapon");
            defenseStat = this.defenseStat;

        } else if (attackType == 2) { //Special Attack
            defenseStat = this.sDefenseStat;
            System.out.println(attackerName + " casts a spell");

        }

        double attackPower = (((levelDamage * (attackValue / defenseStat) / 50) + 2)) * getCrit();
        subHealth((int) attackPower);

        System.out.println(attackerName + " hits for " + attackPower + " damage" + "\n");

    }

    public void subHealth(int attackPower) {
        super.currentHP -= attackPower;
        if (super.currentHP < 0) {
            super.currentHP = 0;
        }
    }

    public void subMana(int manaCost) {
        super.mana -= manaCost;

        if(super.mana < 0) {
            super.mana = 0;
        }
    }

    public void heal(int healValue) {
        super.currentHP += healValue;
        if(super.currentHP > super.maxHP) {
            super.currentHP = super.maxHP;
        }
        System.out.println("You've been healed");
    }

    public double getCrit() {
        double critValue = 0;

        if (Math.random() >= (1 - super.critChance)) {
            System.out.println("Critical hit!");
            critValue = 1.5;
        } else {
            critValue = 1;
        }

        return critValue;
    }


    public boolean manaCheck(int manaCost) {
        return manaCost < super.mana;
    }
}

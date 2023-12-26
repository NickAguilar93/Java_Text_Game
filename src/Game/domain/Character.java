package Game.domain;

public class Character {
    public int currentHP;
    public double attackStat; //Physical attack stat
    public double sAttackStat; //Special attack stat
    public double defenseStat; //Physical defence stat
    public double sDefenseStat; //Special defence stat
    public int mana;
    public int maxHP;
    public int maxMana;
    public String name;
    public int level;
    public double critChance;
    public double burn;

    public Character(String name, int HP, int mana , int attack, int sAttack, int defense, int sDefense) {
        this.name = name;
        this.currentHP = HP;
        this.maxHP = HP;
        this.mana = mana;
        this.maxMana = mana;
        this.attackStat = attack;
        this.sAttackStat = sAttack;
        this.defenseStat = defense;
        this.sDefenseStat = sDefense;
        this.level = 1;
        this.critChance = 0.2;
    }

    public String hpToString() {
        return this.currentHP + "/" + this.maxHP;
    }

    public String manaToString() {
        return this.mana + "/" + this.maxMana;
    }




}

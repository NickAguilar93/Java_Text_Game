package Game.domain;

import Game.logic.CharacterLogic;

public class NPC extends CharacterLogic {


    public NPC(String name, int HP, int mana, int attack, int sAttack, int defense, int sDefense) {
        super(name,HP,mana,attack,sAttack,defense,sDefense);
    }

}

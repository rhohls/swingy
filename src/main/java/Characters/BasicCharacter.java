package Characters;

import Items.*;
import java.util.ArrayList;

public class BasicCharacter {

    String name;
    int maxHP;
    int attack;
    int defence;
    int HP;

//    int modAttack;
//    int modDefence;
//    int modHP;

//    BasicCharacter(){}

    BasicCharacter(String name, int HP, int attack, int defence, int maxHP){
        this.name = name;
        this.maxHP = maxHP;
        this.attack = attack;
        this.defence = defence;
        this.HP = HP;
    }


    int makeAttack(){
        return attack;
    }

    void takeDamage(int damageAmount){
        damageAmount -= defence;
        if (damageAmount < 0)
            damageAmount = 0;

    }


//    private void modifyStats(){
//        modAttack = attack;
//        modDefence = defence;
//        for (Item item: this.itemList) {
//
//        }
//    }



}

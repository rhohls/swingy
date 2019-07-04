package Characters;

import Game.CoOrdinates;
import Items.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class BasicCharacter {

    String name;
    int maxHP;
    int attack;
    int defence;
    int HP;
    @Setter public CoOrdinates coordinates;

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
        this.coordinates = new CoOrdinates(0,0);
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

    public void moveUp(){
        coordinates.setY(coordinates.getY() + 1);
    }
    public void moveDown(){
        coordinates.setY(coordinates.getY() - 1);
    }
    public void moveLeft(){
        coordinates.setX(coordinates.getX() - 1);
    }
    public void moveRight(){
        coordinates.setX(coordinates.getX() + 1);
    }
}

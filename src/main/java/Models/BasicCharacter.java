package Models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
public class BasicCharacter {

//    @NotNull
//    @Min(1)
    @NotBlank
    String name;
    int maxHP;
    int attack;
    int defence;
    public int HP;
    @Setter public CoOrdinates coordinates;

    BasicCharacter(String name, int HP, int attack, int defence, int maxHP){
        this.name = name;
        this.maxHP = maxHP;
        this.attack = attack;
        this.defence = defence;
        this.HP = HP;
        this.coordinates = new CoOrdinates(0,0);
    }

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

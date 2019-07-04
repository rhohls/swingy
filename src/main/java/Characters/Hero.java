package Characters;

import Items.*;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Hero extends BasicCharacter{

    ArrayList<Item> itemList;
    int level;

    public Hero(String name, int HP, int attack, int defence, int maxHP, int level) {
        super(name, maxHP, attack, defence, HP);

        this.level = level;
        itemList = new ArrayList<Item>();
    }


    public void addItems(Item item){
        itemList.add(item);

        if (item instanceof Armor)
            defence += item.getValue();
        else if (item instanceof Helm)
            HP += item.getValue();
        else if (item instanceof Weapon)
            attack += item.getValue();
    }


}
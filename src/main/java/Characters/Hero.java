package Characters;

import Items.*;

import java.util.ArrayList;

public class Hero extends BasicCharacter{

    ArrayList<Item> itemList;

    public Hero(String name, int HP, int attack, int defence, int maxHP) {
        super(name, maxHP, attack, defence, HP);
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
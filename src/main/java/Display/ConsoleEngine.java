package Display;

import Characters.Hero;
import Game.Map;

public class ConsoleEngine {


    public void display(Hero hero, Map map){
        clear();


        System.out.println("Name: " + hero.getName());
        System.out.println();
        System.out.println("HP: " + hero.getHP());
        System.out.println("Attack: " + hero.getAttack());
        System.out.println("Defense: " + hero.getDefence());
        System.out.println("Map size: "+ map.getSize() + "x" + map.getSize());
        System.out.println("Position: x-" + hero.getCoordinates().getX() + " y-" + hero.getCoordinates().getY());
        System.out.println();
    }



    void clear(){
//        try {
//            Runtime.getRuntime().exec("clear");
//        }
//        catch (Exception e){
//            //TODO
//        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

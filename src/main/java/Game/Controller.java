package Game;

import Characters.Enemy;
import Characters.Hero;
import Display.*;
import Helper.FightResult;
import Helper.FileManipulation;
import lombok.Getter;

import java.util.Random;

public class Controller {

    private FileManipulation fm = new FileManipulation();
    @Getter
    private Hero hero;
    @Getter
    private Map map;

//    private Display display;
    private ConsoleEngine display;
    Random random = new Random();


    public void setHero(String heroFileName) throws Exception{
        hero = fm.createFromFile(heroFileName);
    }
    public void initMap(){
        map = new Map(hero.getLevel());
        hero.coordinates.setMax(map.getSize());
    }

    public Hero heroFileInfo(String heroFileName){
        try {
            return fm.createFromFile(heroFileName);
        }
        catch (Exception e) {
            return null;
        }
    }

    /*
    0. Normal move
    1. Fight
    2. Game end / beat map
     */
    public int move(String direction){
        switch (direction){
            case "north":
                hero.moveUp();
                break;

            case "east":
                hero.moveRight();
                break;

            case "south":
                hero.moveDown();
                break;

            case "west":
                hero.moveLeft();
                break;
        }
        //edge of map
        if (hero.coordinates.outOfBounds()){
            return 2;
        }
        //fight?
        if (map.occupied(hero.getCoordinates())){
            return 1;
        }
        return 0;
    }

    public FightResult fight() {
        FightResult result = new FightResult();

        Enemy enemy = new Enemy("Enemy", 10,15,10,10);

        int damage = enemy.getAttack() - hero.getDefence();

        if (damage > 0) {
            result.damageTaken = damage;
            hero.HP -= damage;
        }
        else{
            result.damageTaken = 0;
        }

        if(hero.addExperience())
            result.levelUp = true;
        else
            result.levelUp = false;

        //todo drop item
        return result;

    }

    public boolean runAway(){
        return (random.nextBoolean());
    }
}

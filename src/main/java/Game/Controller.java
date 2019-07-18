package Game;

import Characters.Enemy;
import Characters.Hero;
import Display.Display;
import Helper.FileManipulation;
import lombok.Getter;

public class Controller {

    private FileManipulation fm = new FileManipulation();
    @Getter
    private Hero hero;
    @Getter
    private Map map;

    private Display display;


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

    public void move(String direction){
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


        //fight?
        if (map.occupied(hero.getCoordinates())){
            fight();

            if (hero.HP <= 0){
                display.heroDead();
                break loop;
            }

            display.cont();
        }

        //edge of map
        if (hero.coordinates.outOfBounds()){
            display.beatMap();
            break loop;
        }
    }



    private void fight() {
        if (runAway()){
            return;
        }

        Enemy enemy = new Enemy("Enemy", 10,15,10,10);

        int damage = enemy.getAttack() - hero.getDefence();

        display.takeDamage(damage);
        hero.HP -= damage;

        if(hero.addExperience())
            display.levelUp();

        //todo drop item

    }


    private boolean runAway(){
        if (!display.startFight()){
            if (random.nextBoolean()){
                display.fightRunSuccess();
                return true;
            }
            display.fightRunFail();
        }
        return false;
    }




}

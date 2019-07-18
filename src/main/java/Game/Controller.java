package Game;

import Characters.Hero;
import Helper.FileManipulation;
import lombok.Getter;

public class Controller {

    private FileManipulation fm = new FileManipulation();
    @Getter
    private Hero hero;
    @Getter
    private Map map;


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
    }


}

package Game;

import Characters.Hero;
import Helper.FileManipulation;

public class Controller {

    private FileManipulation fm = new FileManipulation();
    private Hero hero;


    public void setHero(String heroFileName) throws Exception{
        hero = fm.createFromFile(heroFileName);
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
        //case switch statement
    }


}

package Display;

import Game.Controller;
import Helper.FightResult;
import lombok.Getter;
import uiForms.IDisplay;
import uiForms.SwingUI;

import javax.swing.*;
import java.io.File;

public class GUIController {

    private static GUIController ourInstance = new GUIController();
    public static GUIController getInstance() {
        return ourInstance;
    }
    public GUIController(){}


    @Getter
    private static Controller controller;

    private IDisplay display;
    private JFrame frame;
    private File[] fileList;

    public void init(File[] fileList){
        controller = new Controller();
        this.fileList = fileList;
        display = new SwingUI();
    }

    public void openMainMenu(){
        display.openMainMenu(fileList);

    }

    public void startGame(String heroName) throws Exception{
        controller.setHero(heroName);
        controller.initMap();

        display.startGame();
    }
    

    /*
    0. Normal move
    1. Fight
    2. Game end
    */

    public void move(String direction){
        switch (controller.move(direction)){
            case 0:
                display.updateDisplay();
                break;
            case 1:
                display.displayFight();
                break;
            case 2:
                display.displayWin();
//                controller.saveHero();
                openMainMenu();
                break;
        }
    }

    public void runAway() {
        if(controller.runAway()){
            display.runAwaySuccess();
        }
        else{
            display.runAwayFail();
            chooseFight();
        }
    }

    public void chooseFight() {
        FightResult result =  controller.fight();
        display.fightResult(result);
    }
}

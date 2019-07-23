package Display;

import Game.GameState;
import Helper.FightResult;
import lombok.Getter;
import uiForms.IDisplay;
import uiForms.SwingUI;

import javax.swing.*;
import java.io.File;

public class Controller {

    private static Controller ourInstance = new Controller();
    public static Controller getInstance() {
        return ourInstance;
    }
    public Controller(){}


    @Getter
    private static GameState gameState;

    private IDisplay display;
    private JFrame frame;
    private File[] fileList;

    public void init(File[] fileList){
        gameState = new GameState();
        this.fileList = fileList;
        display = new SwingUI();
    }

    public void openMainMenu(){
        display.openMainMenu(fileList);

    }

    public void startGame(String heroName) throws Exception{
        gameState.setHero(heroName);
        gameState.initMap();

        display.startGame();
    }
    

    /*
    0. Normal move
    1. Fight
    2. Game end
    */

    public void move(String direction){
        switch (gameState.move(direction)){
            case 0:
                display.updateDisplay();
                break;
            case 1:
                display.displayFight();
                break;
            case 2:
                display.displayWin();
//                gameState.saveHero();
                openMainMenu();
                break;
        }
    }

    public void runAway() {
        if(gameState.runAway()){
            display.runAwaySuccess();
        }
        else{
            display.runAwayFail();
            chooseFight();
        }
    }

    public void chooseFight() {
        FightResult result =  gameState.fight();
        display.fightResult(result);
    }
}

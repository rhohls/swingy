package Display;

import Characters.Hero;
import Game.GameState;
import Helper.FightResult;
import lombok.Getter;
import lombok.Setter;
import uiForms.IDisplay;

import javax.swing.*;
import java.io.File;

public class Controller {

    private static Controller ourInstance = new Controller();
    public static Controller getInstance() {
        return ourInstance;
    }
    public Controller(){}


    public static GameState getGameState() {
        return gameState;
    }

    @Getter
    private static GameState gameState = new GameState();

    public void setDisplay(IDisplay display) {
        this.display = display;
    }

    @Setter
    private IDisplay display;
    private JFrame frame;
    private File[] fileList;

    public void init(File[] fileList){
        this.fileList = fileList;
    }

    public void openMainMenu(){
        display.openMainMenu(fileList);
    }

    public void startGame(String heroName) throws Exception{
        gameState.setHeroFromFile(heroName);
        gameState.initMap();

        display.startGame();
    }

    public void newHero(String name){
        Hero hero = new Hero(name, 10, 10, 10, 10, 1);

        //bad, see above
        gameState.setHero(hero);
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
                if (!gameState.saveHero())
                    display.failSave();
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
        if (gameState.getHero().getHP() <= 0) {
            display.heroDead();
            openMainMenu();
        }
    }
}

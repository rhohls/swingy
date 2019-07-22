package Display;

import Game.Controller;
import Helper.FightResult;
import lombok.Getter;
import uiForms.GameSwingUI;
import uiForms.MenuSwingUI;

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
    private MenuSwingUI menuSwingUI;
    private GameSwingUI gameSwingUI;
    private JFrame frame;
    private File[] fileList;

    public void init(File[] fileList){
        controller = new Controller();
        menuSwingUI = new MenuSwingUI();
        gameSwingUI = new GameSwingUI();

        this.fileList = fileList;

        frame = new JFrame("Swingy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void openMainMenu(){
        /* Adding items to combobox */
        menuSwingUI.getHeroSelectCombo().removeItem("String");
        for (int i=0; i < fileList.length; i++){
            String str = fileList[i].getName();
            menuSwingUI.getHeroSelectCombo().addItem(str);
        }

        frame.setContentPane(menuSwingUI.getPanel1());
        frame.pack();
        frame.setVisible(true);
    }

    public void startGame(String heroName) throws Exception{
        controller.setHero(heroName);
        controller.initMap();

        frame.setContentPane(gameSwingUI.getPanel());
        frame.setSize(600,400);
        frame.setVisible(true);

        gameSwingUI.updateDisplay();
    }
    

    /*
    0. Normal move
    1. Fight
    2. Game end
    */

    public void move(String direction){
        switch (controller.move(direction)){
            case 0:
                gameSwingUI.updateDisplay();
                break;
            case 1:
                gameSwingUI.displayFight();
                break;
            case 2:
                gameSwingUI.displayWin();
//                controller.saveHero();
                openMainMenu();
                break;
        }
    }

    public void runAway() {
        if(controller.runAway()){
            gameSwingUI.runAwaySuccess();
        }
        else{
            gameSwingUI.runAwayFail();
            chooseFight();
        }
    }

    public void chooseFight() {
        FightResult result =  controller.fight();
        gameSwingUI.fightResult(result);

    }
}

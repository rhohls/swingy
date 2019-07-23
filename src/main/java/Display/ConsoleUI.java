package Display;

import Characters.Hero;
import Helper.FightResult;
import uiForms.IDisplay;

import java.io.File;



public class ConsoleUI  implements IDisplay {
    Hero heroSelected;
    File[] heroList;
    private Controller controller;

    public ConsoleUI(){
        controller = Controller.getInstance();
    }

    @Override
    public void openMainMenu(File[] fileList) {
        heroList = fileList;



    }

    @Override
    public void startGame() {

    }

    @Override
    public void updateDisplay() {

    }

    @Override
    public void displayFight() {

    }

    @Override
    public void displayWin() {

    }

    @Override
    public void runAwaySuccess() {

    }

    @Override
    public void runAwayFail() {

    }

    @Override
    public void fightResult(FightResult result) {

    }


    private void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

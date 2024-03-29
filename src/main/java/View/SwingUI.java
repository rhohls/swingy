package View;

import Helper.FightResult;
import View.uiForms.GameSwingUI;
import View.uiForms.MenuSwingUI;

import javax.swing.*;
import java.io.File;

public class SwingUI implements IDisplay {
    private MenuSwingUI menuSwingUI;
    private GameSwingUI gameSwingUI;
    private JFrame frame;

    public SwingUI(){
        menuSwingUI = new MenuSwingUI();
        gameSwingUI = new GameSwingUI();

        frame = new JFrame("Swingy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        System.out.println("swing constructor done");
    }

    @Override
    public void openMainMenu(File[] fileList){
        menuSwingUI.getHeroSelectCombo().removeAllItems();

        for (int i=0; i < fileList.length; i++){
            String str = fileList[i].getName();
            menuSwingUI.getHeroSelectCombo().addItem(str);
        }

        frame.setContentPane(menuSwingUI.getPanel1());
        frame.setSize(600,400);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void startGame(){
        frame.setContentPane(gameSwingUI.getPanel());
        frame.setSize(600,400);
        frame.setVisible(true);

        gameSwingUI.updateDisplay();
    }


    @Override
    public void updateDisplay() {
        gameSwingUI.updateDisplay();
    }

    @Override
    public void displayFight() {
        gameSwingUI.displayFight();
    }

    @Override
    public void displayWin() {
        gameSwingUI.displayWin();
    }

    @Override
    public void runAwaySuccess() {
        gameSwingUI.runAwaySuccess();
    }

    @Override
    public void runAwayFail() {
        gameSwingUI.runAwayFail();
    }

    @Override
    public void fightResult(FightResult result) {
        gameSwingUI.fightResult(result);
    }

    @Override
    public void heroDead() {
        gameSwingUI.heroDead();
    }

    @Override
    public void failSave() {
        gameSwingUI.failSave();
    }
}

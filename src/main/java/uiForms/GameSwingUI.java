package uiForms;

import Display.Controller;
import Helper.FightResult;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class GameSwingUI {
    private Controller controller;

    private JButton southBtn;
    private JButton westBtn;
    private JButton eastBtn;
    private JButton northBtn;
    private JTextArea infoAreaTxt;
    private JButton fightBtn;
    private JButton runBtn;
    private JPanel panel;
    private JButton continueBtn;

    public GameSwingUI(){
        this.controller = Controller.getInstance();

        southBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("south");
            }
        });
        northBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("north");
            }
        });
        westBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("west");
            }
        });
        eastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("east");
            }
        });

        fightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.chooseFight();
            }
        });
        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.runAway();
            }
        });
        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fightContinue();
            }
        });

    }

    public void updateDisplay(){
        infoAreaTxt.setText(null);

        infoAreaTxt.append("Name: " + controller.getGameState().getHero().getName() + "\n");
        infoAreaTxt.append("" + "\n");
        infoAreaTxt.append("HP: " + controller.getGameState().getHero().getHP() + "\n");
        infoAreaTxt.append("Attack: " + controller.getGameState().getHero().getAttack() + "\n");
        infoAreaTxt.append("Defense: " + controller.getGameState().getHero().getDefence() + "\n");
        infoAreaTxt.append("Map size: "+ controller.getGameState().getMap().getSize()
                                    + "x" + controller.getGameState().getMap().getSize() + "\n");
        infoAreaTxt.append("Position: x-" + controller.getGameState().getHero().getCoordinates().getX() +
                                    " y-" + controller.getGameState().getHero().getCoordinates().getY() + "\n");
    }

    public void displayFight(){
        fightBtn.setEnabled(true);
        runBtn.setEnabled(true);

        southBtn.setEnabled(false);
        westBtn.setEnabled(false);
        eastBtn.setEnabled(false);
        northBtn.setEnabled(false);

        infoAreaTxt.setText(null);
        infoAreaTxt.append("You see an enemy approaching" + "\n");
        infoAreaTxt.append("Would you like to fight or run?" + "\n\n");
    }

    public void runAwaySuccess() {
        infoAreaTxt.append("Great success, you ran away" + "\n");
        continueButtons();
    }

    public void runAwayFail() {
        infoAreaTxt.append("You failed at running away prepare for a fight" + "\n\n");
    }

    public void fightResult(FightResult result) {
        infoAreaTxt.append("Damage taken: " + result.damageTaken + "\n");
        if (result.levelUp)
            infoAreaTxt.append("You leveled up" + "\n");

        continueButtons();
    }

    private void fightContinue() {
        fightBtn.setEnabled(false);
        runBtn.setEnabled(false);
        continueBtn.setEnabled(false);

        southBtn.setEnabled(true);
        westBtn.setEnabled(true);
        eastBtn.setEnabled(true);
        northBtn.setEnabled(true);

        updateDisplay();
    }
    private void continueButtons(){
        fightBtn.setEnabled(false);
        runBtn.setEnabled(false);

        continueBtn.setEnabled(true);
    }

    public void displayWin() {
        JOptionPane.showMessageDialog(null, "You won! Well done");
    }

    public void heroDead() {
        infoAreaTxt.setText(null);
        infoAreaTxt.append("\n" + controller.getGameState().getHero().getName() + " is dead.");
        infoAreaTxt.append("Sorry :(");
    }
}

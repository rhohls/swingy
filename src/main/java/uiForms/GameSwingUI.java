package uiForms;

import Display.GUIController;
import Game.Controller;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class GameSwingUI {
    private GUIController controller;

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
        this.controller = GUIController.getInstance();


        southBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("south");
//                updateDisplay();
            }
        });
        northBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("north");
//                updateDisplay();
            }
        });
        westBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("west");
//                updateDisplay();
            }
        });
        eastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("east");
//                updateDisplay();
            }
        });
    }


    public void updateDisplay(){
        infoAreaTxt.setText(null);

        infoAreaTxt.append("Name: " + controller.getController().getHero().getName() + "\n");
        infoAreaTxt.append("" + "\n");
        infoAreaTxt.append("HP: " + controller.getController().getHero().getHP() + "\n");
        infoAreaTxt.append("Attack: " + controller.getController().getHero().getAttack() + "\n");
        infoAreaTxt.append("Defense: " + controller.getController().getHero().getDefence() + "\n");
        infoAreaTxt.append("Map size: "+ controller.getController().getMap().getSize()
                                    + "x" + controller.getController().getMap().getSize() + "\n");
        infoAreaTxt.append("Position: x-" + controller.getController().getHero().getCoordinates().getX() +
                                    " y-" + controller.getController().getHero().getCoordinates().getY() + "\n");
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void displayFight(){
        fightBtn.setEnabled(true);
        runBtn.setEnabled(true);
        continueBtn.setEnabled(true);

        southBtn.setEnabled(false);
        westBtn.setEnabled(false);
        eastBtn.setEnabled(false);
        northBtn.setEnabled(false);


        infoAreaTxt.setText(null);

        infoAreaTxt.append("You see an enemy approaching" + "\n");
        infoAreaTxt.append("Would you like to fight or run?" + "\n");
    }
}

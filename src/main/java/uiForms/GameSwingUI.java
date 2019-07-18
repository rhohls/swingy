package uiForms;

import Display.GUIController;
import Game.Controller;
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
    private JButton fight;
    private JButton run;
    private JPanel panel;

    public GameSwingUI(){
        this.controller = GUIController.getInstance().getController();


        southBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("south");
                updateDisplay();
            }
        });
        northBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("north");
                updateDisplay();
            }
        });
        westBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("west");
                updateDisplay();
            }
        });
        eastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.move("east");
                updateDisplay();
            }
        });
    }


    public void updateDisplay(){
        infoAreaTxt.setText(null);



        infoAreaTxt.append("Name: " + controller.getHero().getName() + "\n");
        infoAreaTxt.append("" + "\n");
        infoAreaTxt.append("HP: " + controller.getHero().getHP() + "\n");
        infoAreaTxt.append("Attack: " + controller.getHero().getAttack() + "\n");
        infoAreaTxt.append("Defense: " + controller.getHero().getDefence() + "\n");
        infoAreaTxt.append("Map size: "+ controller.getMap().getSize() + "x" + controller.getMap().getSize() + "\n");
        infoAreaTxt.append("Position: x-" + controller.getHero().getCoordinates().getX() + " y-" + controller.getHero().getCoordinates().getY() + "\n");

    }


}

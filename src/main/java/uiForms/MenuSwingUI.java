package uiForms;

import Characters.Hero;
import Display.Controller;
import Game.GameState;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class MenuSwingUI {
    private GameState controller;

    public JPanel getPanel1() {
        return panel1;
    }

    private JPanel panel1;
    private JTextArea heroDisplay;

    public JComboBox getHeroSelectCombo() {
        return heroSelectCombo;
    }

    private JComboBox heroSelectCombo;
    private JButton viewHeroBtn;
    private JButton submitBtn;


    public MenuSwingUI() {
        System.out.println("menu Constructor start");

        this.controller = Controller.getInstance().getGameState();

        //hero selection
        viewHeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero hero = controller.heroFileInfo(heroSelectCombo.getSelectedItem().toString());
                displayInfo(hero);
            }
        });

        //start Game
        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Controller.getInstance().startGame(heroSelectCombo.getSelectedItem().toString());
                } catch (Exception e1) {
                    e1.printStackTrace();
                    heroDisplay.setText("There was an error starting the game");
                }
            }
        });

        System.out.println("menu Constructor done");
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//        heroSelectCombo = new JComboBox();
//
//    }

    private void displayInfo(Hero hero) {
        heroDisplay.setText(null);
        if (hero == null) {
            heroDisplay.append("There was an issue with the file");
        } else {
            heroDisplay.append("Name: " + hero.getName() + "\n");
            heroDisplay.append("HP: " + hero.getHP() + "\n");
            heroDisplay.append("Attack: " + hero.getAttack() + "\n");
            heroDisplay.append("Defense: " + hero.getDefence() + "\n");
        }
    }

}



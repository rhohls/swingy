package View.uiForms;

import Models.Hero;
import Controller.Controller;
import Controller.GameState;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class MenuSwingUI {
    private GameState gameState;
    private Controller controller;

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
    private JTextField newHeroNameTextField;
    private JButton newHeroButton;

    public MenuSwingUI() {
//        System.out.println("menu Constructor start");

        this.gameState = Controller.getInstance().getGameState();
        this.controller = Controller.getInstance();

        //hero selection
        viewHeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero hero = gameState.heroFileInfo(heroSelectCombo.getSelectedItem().toString());
                displayInfo(hero);
            }
        });

        // heroSelectCombo.actionPerformed();
        // todo auto display info

        //start Controller
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

        //create new hero
        newHeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.newHero(newHeroNameTextField.getText());
                } catch (Exception ex) {
                    heroDisplay.setText("There was an error creating the hero");
                }
            }
        });

//        System.out.println("menu Constructor done");
    }

//    private void createUIComponents() {
//        // : place custom component creation code here
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

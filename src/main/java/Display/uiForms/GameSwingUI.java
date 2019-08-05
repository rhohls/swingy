package Display.uiForms;

import Game.Controller;
import Helper.FightResult;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
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

    public JPanel getPanel() {
        return panel;
    }

    private JPanel panel;
    private JButton continueBtn;

    public GameSwingUI() {
        this.controller = Controller.getInstance();

        //direction buttons
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

        //auxiliary buttons
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

        System.out.println("game constructor");
    }

    public void updateDisplay() {
        infoAreaTxt.setText(null);

        infoAreaTxt.append("Name: " + controller.getGameState().getHero().getName() + "\n");
        infoAreaTxt.append("" + "\n");
        infoAreaTxt.append("HP: " + controller.getGameState().getHero().getHP() + "\n");
        infoAreaTxt.append("Attack: " + controller.getGameState().getHero().getAttack() + "\n");
        infoAreaTxt.append("Defense: " + controller.getGameState().getHero().getDefence() + "\n");
        infoAreaTxt.append("Map size: " + controller.getGameState().getMap().getSize()
                + "x" + controller.getGameState().getMap().getSize() + "\n");
        infoAreaTxt.append("Position: x-" + controller.getGameState().getHero().getCoordinates().getX() +
                " y-" + controller.getGameState().getHero().getCoordinates().getY() + "\n");
    }

    public void displayFight() {
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
        infoAreaTxt.append("You defeated your enemy but took: " + result.damageTaken + "points of damage\n");

        if (result.itemDropped != null){
            infoAreaTxt.append("You got an item\n");
            infoAreaTxt.append("It is a " + result.itemDropped.name);
            infoAreaTxt.append(" with value " + result.itemDropped.value);

        if (result.levelUp)
            infoAreaTxt.append("You leveled up" + "\n");
        }


        continueButtons();
    }

    public void heroDead() {
        fightContinue();
        JOptionPane.showMessageDialog(null, "You died, sorry :(");
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

    private void continueButtons() {
        fightBtn.setEnabled(false);
        runBtn.setEnabled(false);

        continueBtn.setEnabled(true);
    }

    public void displayWin() {
        JOptionPane.showMessageDialog(null, "You won! Well done");
    }


    public void failSave() {
        JOptionPane.showMessageDialog(null, "There was an error saving file.");
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        southBtn = new JButton();
        southBtn.setText("South");
        panel.add(southBtn, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        westBtn = new JButton();
        westBtn.setText("West");
        panel.add(westBtn, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        eastBtn = new JButton();
        eastBtn.setText("East");
        panel.add(eastBtn, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        northBtn = new JButton();
        northBtn.setText("North");
        panel.add(northBtn, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        infoAreaTxt = new JTextArea();
        panel.add(infoAreaTxt, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        fightBtn = new JButton();
        fightBtn.setEnabled(false);
        fightBtn.setText("Fight");
        panel.add(fightBtn, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        runBtn = new JButton();
        runBtn.setEnabled(false);
        runBtn.setText("Run");
        panel.add(runBtn, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        continueBtn = new JButton();
        continueBtn.setEnabled(false);
        continueBtn.setText("Continue");
        panel.add(continueBtn, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}

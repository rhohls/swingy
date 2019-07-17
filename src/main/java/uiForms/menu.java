package uiForms;

import Characters.Hero;
import lombok.Getter;

import javax.swing.*;
import java.io.File;

@Getter
public class menu {
    private JPanel panel1;
    private JTextArea heroDisplay;
    private JComboBox heroSelectCombo;
    private JButton viewHeroBtn;
    private JButton submitBtn;

    public menu(){

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        heroSelectCombo = new JComboBox();

    }

    public void displayInfo(Hero hero){
        heroDisplay.append("Name: " + hero.getName() + "\n");
        heroDisplay.append("HP: " + hero.getHP() + "\n");
        heroDisplay.append("Attack: " + hero.getAttack() + "\n");
        heroDisplay.append("Defense: " + hero.getDefence() + "\n");
    }
}



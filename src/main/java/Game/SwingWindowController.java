package Game;

import uiForms.MenuSwingUI;

import javax.swing.*;
import java.io.File;

public class SwingWindowController{
    private JFrame frame;

    MenuSwingUI menuWindow = new MenuSwingUI();

    SwingWindowController(File[] fileList){

        /* Adding items to combobox */
            menuWindow.getHeroSelectCombo().removeItem("String");
            for (int i=0; i < fileList.length; i++){
            String str = fileList[i].getName();
            menuWindow.getHeroSelectCombo().addItem(str);
        }
    }

    public void openMainMenuWindow() {
        frame = new JFrame("Main Menu");

        frame.setContentPane(menuWindow.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

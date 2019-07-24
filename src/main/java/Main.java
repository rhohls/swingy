import Display.ConsoleEngine;
import Display.ConsoleUI;
import Display.Controller;

import java.io.*;

import Helper.FileManipulation;
import uiForms.IDisplay;
import uiForms.SwingUI;

public class Main {

    public static void main(String[] args) {
        System.out.println("arg  " + args[0]);

        FileManipulation fm = new FileManipulation();
        IDisplay UI;
        File[] fileList;

        //Usage
        if (args.length != 1 ) {
            System.out.println("Usage:");
            System.out.println("console - for console display");
            System.out.println("gui - swing library");
            return;
        }

        //Get hero files
        try {
            fileList = fm.getFiles();
        }
        catch (Exception e){
            System.out.println("Error getting folders");
            return;
        }

        //init controller
        Controller controller = Controller.getInstance();
        controller.init(fileList);

        //UI
        if (args[0].toLowerCase().equals("console"))
            UI = new ConsoleUI();
        else if (args[0].toLowerCase().equals("gui"))
            UI = new SwingUI();
        else{
            System.out.println("Usage:");
            System.out.println("console - for console display");
            System.out.println("gui - swing library");
            return;
        }
        controller.setDisplay(UI);

        //Start
        controller.openMainMenu();
    }
}

import Display.ConsoleUI;
import Game.Controller;

import java.io.*;

import Helper.FileManipulation;
import Display.IDisplay;
import Display.SwingUI;

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



        //init controller
        Controller controller = Controller.getInstance();
//        controller.initFileList();


//        System.out.println("test:");
//
//        if (args[0].toLowerCase().equals("console")) {
//            System.out.println("console");
//        }
//        else if (args[0].toLowerCase().equals("gui")) {
//            System.out.println("swing");
//        }
//        else{
//            System.out.println("Usage:");
//            System.out.println("console - for console display");
//            System.out.println("gui - swing library");
//            return;
//        }


        //UI
        //todo switching
        if (args[0].toLowerCase().equals("console")) {
            UI = new ConsoleUI();
            System.out.println("made console");
        }
        else if (args[0].toLowerCase().equals("gui")) {
            UI = new SwingUI();
            System.out.println("made swing");
        }
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

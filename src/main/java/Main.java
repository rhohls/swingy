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

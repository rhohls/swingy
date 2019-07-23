import Display.ConsoleEngine;
import Display.ConsoleUI;
import Display.Controller;

import java.io.*;

import Helper.FileManipulation;
import uiForms.IDisplay;
import uiForms.SwingUI;

public class Main {

    public static void main(String[] args) {

        System.out.println("arg number " + args.length);
        System.out.println("arg 0 " + args[0]);


        FileManipulation fm = new FileManipulation();
        ConsoleEngine disp = new ConsoleEngine();

        File[] fileList;
        try {
            fileList = fm.getFiles();
        }
        catch (Exception e){
            System.out.println("Error getting folders");
            return;
        }

        if (args.length != 1 ) {
            System.out.println("Usage:");
            System.out.println("console - for console display");
            System.out.println("gui - swing library");
            return;
        }

        IDisplay UI;
        System.out.println("lower " + args[0].toLowerCase());
        System.out.println("gui?? " + args[0].toLowerCase().equals("gui"));

        Controller controller = Controller.getInstance();


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

//        Controller controller = Controller.getInstance();
        controller.init(fileList, UI);

        controller.openMainMenu();


    }
}

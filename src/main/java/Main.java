import Display.ConsoleEngine;
import Display.Controller;

import java.io.*;

import Helper.FileManipulation;

public class Main {

    public static void main(String[] args) {


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
        }

        Controller guiController = Controller.getInstance();
        guiController.init(fileList);

        guiController.openMainMenu();

//        JFrame frame = new JFrame();
//        GameSwingUI gameSwingUI = new GameSwingUI();
//
//        frame.setContentPane(gameSwingUI.getPanel());
////        frame.pack();
//        frame.setVisible(true);



//        Hero testHero;
//        try {
//            testHero = fm.createFromFile("Steve.json");
//            menuWindow.displayInfo(testHero);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println(menuWindow.getHeroSelectCombo().getSelectedItem().toString());
//
//        try
//        {
//            Thread.sleep(5000);
//        }
//        catch(InterruptedException ex)
//        {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println(menuWindow.getHeroSelectCombo().getSelectedItem().toString());
//
//        GameSwingUI gameWindow = new GameSwingUI();
//
//        frame.setVisible(false);
////        frame.setContentPane(gameWindow.getPanel());
////        frame.setVisible(true);





//        Game game = new Game(disp);
//        int gameReturn = 0;
//        Hero hero = null;
//        Map map = null;
//        /*
//        1. Exit GameSwingUI
//        2. New hero
//        3. map beaten
//        4. Play GameSwingUI
//         */
//        try {
//
//            String getname = menuWindow.getHeroSelectCombo().getSelectedItem().toString();
//            System.out.println("name: " + getname );
//            hero = fm.createFromFile(getname);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        while(true){
//
//            gameReturn = disp.mainMenu(hero);
//
//            //choose hero
//            if (gameReturn == 2) {
//                String heroFileName = disp.heroFileName(fileList);
//                try {
//                    hero = fm.createFromFile(heroFileName);
//                }
//                catch (Exception e) {
//                    disp.except(e);
//                }
//            }
//
//
//
//            if (gameReturn == 4 && hero != null) {
//                //create map

//
//                game.setMap(map);
//                game.setHero(hero);
//
//                gameReturn = game.Loop();
//            }
//
//            //save file
//            if (gameReturn == 3){
//                if (hero != null){
//                    try {
//                        fm.writeHeroToFile(hero, hero.getName());
//                    }
//                    catch (Exception e) {
//                        disp.except(e);
//                    }
//                }
//                break;
//            }
//        }
//
//        disp.goodbye();
    }
}

import Characters.Hero;
import Display.ConsoleEngine;
import Game.Game;
import Game.Map;

import javax.swing.*;
import java.io.*;

import uiForms.menu;

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



        menu menuWindow = new menu(fileList);


        JFrame frame = new JFrame("Main Menu");

        frame.setContentPane(menuWindow.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);









//        Game game = new Game(disp);
//        int gameReturn = 0;
//        Hero hero = null;
//        Map map = null;
//        /*
//        1. Exit game
//        2. New hero
//        3. map beaten
//        4. Play game
//         */
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
//            if (gameReturn == 4 && hero != null) {
//                //create map
//                map = new Map(hero.getLevel());
//                hero.coordinates.setMax(map.getSize());
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

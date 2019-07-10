import Characters.Hero;
import Display.ConsoleEngine;
import Game.Game;
import Game.Map;

import java.io.*;


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

        Game game = new Game(disp);
        int gameReturn = 0;
        Hero hero = null;
        Map map = null;
        /*
        1. Exit game
        2. New hero
        3. map beaten
        4. Play game
         */

        while(true){

            gameReturn = disp.mainMenu(hero);

            //choose hero
            if (gameReturn == 2) {
                String heroFileName = disp.heroFileName(fileList);
                try {
                    hero = fm.createFromFile(heroFileName);
                }
                catch (Exception e) {
                    disp.except(e);
                }
            }

            if (gameReturn == 4 && hero != null) {
                //create map
                map = new Map(hero.getLevel());
                hero.coordinates.setMax(map.getSize());

                game.setMap(map);
                game.setHero(hero);

                gameReturn = game.Loop();
            }

            //save file
            if (gameReturn == 3){
                if (hero != null){
                    try {
                        fm.writeHeroToFile(hero, hero.getName());
                    }
                    catch (Exception e) {
                        disp.except(e);
                    }
                }
                break;
            }
        }

        disp.goodbye();
    }


}


//    //file test
//    FileManipulation fm = new FileManipulation();
//
//    Hero hero = fm.createFromFile("test_file.json");
//        if (hero == null)
//                System.out.println("It was null");
//
//                hero.setCoordinates(new CoOrdinates(4,5));
//                fm.writeHeroToFile(hero, "new_test.json");
//

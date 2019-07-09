import Characters.Hero;
import Display.ConsoleEngine;
import Game.CoOrdinates;
import Game.Game;
import Game.Map;
import Items.Weapon;
import com.google.gson.Gson;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        FileMainpulation fm = new FileMainpulation();
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


            //choose hero
            if (hero == null || gameReturn == 2) {
                String heroFileName = disp.heroFileName(fileList);
                hero = fm.createFromFile(heroFileName);
            }

            //create map
            map = new Map(hero.getLevel());
            hero.coordinates.setMax(map.getSize());

            game.setMap(map);
            game.setHero(hero);

            if (gameReturn != 3)
                gameReturn = game.Loop();

            if (gameReturn == 3){
                //todo save hero to file
                break;
            }

        }

        disp.goodbye();

    }


}


//    //file test
//    FileMainpulation fm = new FileMainpulation();
//
//    Hero hero = fm.createFromFile("test_file.json");
//        if (hero == null)
//                System.out.println("It was null");
//
//                hero.setCoordinates(new CoOrdinates(4,5));
//                fm.writeHeroToFile(hero, "new_test.json");
//

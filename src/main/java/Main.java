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

        Main pls = new Main();

        FileMainpulation fm = new FileMainpulation();
        ConsoleEngine disp = new ConsoleEngine();

        String heroFileName;
        try {
            File[] list = fm.getFiles();
            heroFileName = disp.heroFileName(list);
        }
        catch (Exception e){
            System.out.println("Error getting folders");
            return;
        }

        Game game = new Game(disp);
        int gameReturn = 0;


        while(true){
            //choose hero
            Hero hero = fm.createFromFile(heroFileName);
            //create map
            Map map = new Map(hero.getLevel());
            hero.coordinates.setMax(map.getSize());

            game.setMap(map);
            game.setHero(hero);

            gameReturn = game.Loop();

            switch (gameReturn){
                case 0:
                    break;
            }
        }

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

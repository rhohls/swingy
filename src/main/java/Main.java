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

        Hero hero = fm.createFromFile("new_test.json");
        Map map = new Map(hero.getLevel());
        hero.coordinates.setMax(map.getSize());



        Game game = new Game(map, hero, disp);


        game.Loop();

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

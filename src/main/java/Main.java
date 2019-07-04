import Characters.Hero;
import Display.ConsoleEngine;
import Game.CoOrdinates;
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

        Hero hero = fm.createFromFile("new_test.json");
        Map map = new Map(hero.getLevel());

        ConsoleEngine disp = new ConsoleEngine();


        System.out.println("sdfaasdf");

        disp.display(hero, map);
    }



    public void readInput(){
        Scanner scanner = new Scanner(System.in);
        String inputString;

        loop: while(true){
            System.out.println("Enter a direction: North, East, South, West Or Exit");
            inputString = scanner.nextLine();

            switch (inputString.toLowerCase()){

                case "north":
                case "n":
                    System.out.println("Went North");
                    break;

                case "east":
                case "e":
                    System.out.println("Went East");
                    break;

                case "south":
                case "s":
                    System.out.println("Went South");
                    break;

                case "west":
                case "w":
                    System.out.println("Went West");
                    break;

                case "exit":
                    break loop;
            }

        }

        scanner.close();
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

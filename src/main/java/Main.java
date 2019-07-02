import Characters.Hero;
import Items.Weapon;
import com.google.gson.Gson;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Gson gson = new Gson();

        Hero hero = new Hero("Steve", 32, 45, 10, 50);
        Weapon weapon = new Weapon("spear", 4);

        hero.addItems(weapon);
        hero.addItems(weapon);

        System.out.println(gson.toJson(hero));
        String str = "{\"itemList\":[{\"name\":\"spear\",\"value\":4},{\"name\":\"spear\",\"value\":4}],\"name\":\"Steve\",\"maxHP\":32,\"attack\":53,\"defence\":10,\"HP\":50}";
        Hero hero1 = gson.fromJson(str,  Hero.class);

        hero1.addItems(weapon);


        System.out.println(gson.toJson(hero1));


    }





    public void readInput(){
        Scanner scanner = new Scanner(System.in);
        String inputString;

        System.out.println("Enter a direction: North, East, South, West Or Exit");
        loop: while(true){
            inputString = scanner.nextLine();

            switch (inputString.toLowerCase()){

                case "north":
                case "n":
                    break;

                case "east":
                case "e":
                    break;

                case "south":
                case "s":
                    break;

                case "west":
                case "w":
                    break;

                case "exit":
                    break loop;
            }

            if (inputString.toLowerCase().equals("exit")){
                break;
            }
        }

        scanner.close();
    }
}

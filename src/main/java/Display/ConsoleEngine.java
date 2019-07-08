package Display;

import Characters.Enemy;
import Characters.Hero;
import Game.Map;

import java.io.File;
import java.util.Scanner;

public class ConsoleEngine {

    Scanner scanner = new Scanner(System.in);

    public String heroFileName(File[] listFiles){


        //todo add hero preview
        System.out.println("List of heroes:");

        for (int i=0; i < listFiles.length; i++){
            System.out.println(i + ". " + listFiles[i].getName());
        }

        int input = -1;
        while (input < 0 || input > listFiles.length){
            System.out.println("Enter a number of Hero that you want");
            input = scanner.nextInt();
        }

        return (listFiles[input].getName());
    }


    public void display(Hero hero, Map map){
        clear();

        System.out.println("Name: " + hero.getName());
        System.out.println();
        System.out.println("HP: " + hero.getHP());
        System.out.println("Attack: " + hero.getAttack());
        System.out.println("Defense: " + hero.getDefence());
        System.out.println("Map size: "+ map.getSize() + "x" + map.getSize());
        System.out.println("Position: x-" + hero.getCoordinates().getX() + " y-" + hero.getCoordinates().getY());
        System.out.println();
    }

    public String inputDirection(){

        while(true){
            System.out.println("Enter a direction: North, East, South, West Or Exit");
            String inputString = scanner.nextLine();

            switch (inputString.toLowerCase()) {

                case "north":
                case "n":
                    System.out.println("Went North");
                    return ("north");

                case "east":
                case "e":
                    System.out.println("Went East");
                    return ("east");

                case "south":
                case "s":
                    System.out.println("Went South");
                    return ("south");

                case "west":
                case "w":
                    System.out.println("Went West");
                    return ("west");

                case "exit":
                    return ("exit");
            }
        }
    }

    public boolean startFight(){
        clear();

        System.out.println("You see an enemy approaching");

        while(true) {
            System.out.println("Would you like to fight or run?");
            String inputString = scanner.nextLine();

            switch (inputString.toLowerCase()) {

                case "fight":
                case "f":
                    return (true);

                case "run":
                case "r":
                    return (false);
            }
        }
    }

    public void fightRunSuccess(){
        System.out.println("You successfully ran away");
    }
    public void fightRunFail(){
        System.out.println("You failed at running away");
    }

    public void beatMap(){
        System.out.println("you beat the map");
    }

    public void takeDamage(int damage) {
        System.out.println("You took " + damage + " points of damage.");
    }

    public void heroDead() {
        System.out.println("You died :(");
    }

    public void levelUp() {
        System.out.println("You leveled up, nice.");
    }




    private void clear(){
//        try {
//            Runtime.getRuntime().exec("clear");
//        }
//        catch (Exception e){
//            //TODO
//        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void cont(){
        System.out.println("Press enter to continue");
        String inputString = scanner.nextLine();

    }


}

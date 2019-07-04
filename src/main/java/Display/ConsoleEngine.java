package Display;

import Characters.Enemy;
import Characters.Hero;
import Game.Map;

import java.util.Scanner;

public class ConsoleEngine implements Display{

    Scanner scanner = new Scanner(System.in);


    @Override
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

    public void cont(){
        System.out.println("Press enter to continue");
        String inputString = scanner.nextLine();

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

}

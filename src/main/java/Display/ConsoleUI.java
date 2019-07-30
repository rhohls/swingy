package Display;

import Characters.Hero;
import Helper.FightResult;
import uiForms.IDisplay;

import java.io.File;
import java.util.Scanner;

//FIX LOOP BEING HANDLED.   LOGIC???

public class ConsoleUI  implements IDisplay {
    String heroSelected;
    File[] heroList;
    private Controller controller;
    Scanner scanner = new Scanner(System.in);

    public ConsoleUI(){
        controller = Controller.getInstance();
    }

    private void chooseHero(){
        //todo add hero preview

        int input = -1;
        while (input < 0 || input > heroList.length){
            clear();
            System.out.println("List of heroes:");

            for (int i=0; i < heroList.length; i++){
                String str = heroList[i].getName();
                System.out.println(i + ". " + str.substring(0, str.length() - 5));
            }

            System.out.println("Enter a number of Hero that you want");
            try {
                input = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Please enter a correct number");
            }
        }
        heroSelected = heroList[input].getName();
    }

    @Override
    public void openMainMenu(File[] fileList) {
        heroList = fileList;

        while(true){
            clear();
            System.out.println("Main Menu:");

            if (heroSelected != null)
                System.out.println("Current hero selected: " + heroSelected);
            else
                System.out.println("No hero selected");

            System.out.println("1. Select new hero");
            System.out.println("2. Play Game");
            System.out.println("3. Create new hero and start");
            System.out.println("4. Exit");

            //int parsing
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        chooseHero();
                        break;

                    case 2:
                        if (heroSelected != null){
                            try {
                                controller.startGame(heroSelected);
                            } catch (Exception e) {
                                System.out.println("Error starting the game, check the hero file");
                            }
                        }
                        break;

                    case 3:
                        newHero();
                        break;

                    case 4:
                        System.exit(0);
                        break;
                }

            }
            catch (Exception e){
                //ignore non numbers
            }


        }
    }

    private void newHero(){
        clear();
        System.out.println("Enter a new hero name:");
        String newName = scanner.nextLine();

        controller.newHero(newName);

    }

    @Override
    public void startGame() {
        updateDisplay();
    }

    @Override
    public void updateDisplay() {
        clear();

        System.out.println("Name: " + controller.getGameState().getHero().getName());
        System.out.println();
        System.out.println("HP: " + controller.getGameState().getHero().getHP());
        System.out.println("Attack: " + controller.getGameState().getHero().getAttack());
        System.out.println("Defense: " + controller.getGameState().getHero().getDefence());
        System.out.println("Map size: "+ controller.getGameState().getMap().getSize() + "x"
                                        + controller.getGameState().getMap().getSize());
        System.out.println("Position: x-" + controller.getGameState().getHero().getCoordinates().getX() +
                                    " y-" + controller.getGameState().getHero().getCoordinates().getY());
        System.out.println();

        String move = inputDirection();
        controller.move(move);
    }

    private String inputDirection(){
        while(true){
            System.out.println("Enter a direction: North, East, South, West Or Exit");
            String inputString = scanner.nextLine();

            switch (inputString.toLowerCase()) {

                case "north":
                case "n":
                    return ("north");

                case "east":
                case "e":
                    return ("east");

                case "south":
                case "s":
                    return ("south");

                case "west":
                case "w":
                    return ("west");

                case "exit":
                    return ("exit");
            }
        }
    }

    @Override
    public void displayFight() {
        clear();

        System.out.println("You see an enemy approaching");

        fightloop: while(true) {
            System.out.println("Would you like to fight or run?");
            String inputString = scanner.nextLine();

            switch (inputString.toLowerCase()) {

                case "fight":
                case "f":
                    controller.chooseFight();
                    break fightloop;

                case "run":
                case "r":
                    controller.runAway();
                    break fightloop;

            }
        }
        updateDisplay();
    }

    @Override
    public void displayWin() {
        System.out.println("Congragulations you beat the map");
        cont();
    }

    @Override
    public void runAwaySuccess() {
        System.out.println("You successfully ran away");
        cont();
    }

    @Override
    public void runAwayFail() {
        System.out.println("You failed at running away");
    }

    @Override
    public void fightResult(FightResult result) {
        System.out.println("Damage taken: " + result.damageTaken + "\n");
        if (result.levelUp)
            System.out.println("You leveled up" + "\n");
        if (result.itemDropped != null)
            System.out.println("You got a new item");

        cont();
    }

    @Override
    public void heroDead() {
        clear();
        System.out.println(controller.getGameState().getHero().getName() + " is dead.");
        System.out.println("Sorry :(");
        cont();
    }

    @Override
    public void failSave() {
        clear();
        System.out.println("Error saving hero: " + controller.getGameState().getHero().getName() + " to file");
        cont();
    }


    private void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void cont(){
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
}

package Game;

import Characters.Hero;
import Display.ConsoleEngine;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Map map;
    Hero hero;
    ConsoleEngine display;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Game(Map map, Hero hero, ConsoleEngine display){
        this.map = map;
        this.hero = hero;
        this.display = display;
    }

    public void Loop(){



        String moveResult;

        loop: while(true){

            display.display(hero, map);
            moveResult = display.inputDirection();

            switch (moveResult){
                case "north":
                    hero.moveUp();
                    break;

                case "east":
                    hero.moveRight();
                    break;

                case "south":
                    hero.moveDown();
                    break;

                case "west":
                    hero.moveLeft();
                    break;

                case "exit":
                    break loop;
            }

            //fight?
            if (map.occupied(hero.getCoordinates())){
                fight();
            }

            //edge of map
            if (hero.coordinates.outOfBounds()){
                System.out.println("you beat the map");
                break loop;
            }

        }

        scanner.close();
    }

    private void fight() {
        if (!display.startFight()){
            if (random.nextBoolean()){
                display.fightRunSuccess();
                return;
            }
            display.fightRunFail();
        }

        display.cont();
    }
}

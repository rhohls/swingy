package Game;

import Characters.Enemy;
import Characters.Hero;
import Display.ConsoleEngine;
import lombok.Setter;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;
import java.util.Scanner;

/*
1. Hero dead
2. Beat map
3.
 */

public class Game {
    @Setter Map map;
    @Setter Hero hero;
    ConsoleEngine display;
    Random random = new Random();

    public Game(ConsoleEngine display){
        this.display = display;
    }

    public Game(Map map, Hero hero, ConsoleEngine display){
        this.map = map;
        this.hero = hero;
        this.display = display;
    }

    public int Loop(){
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

                if (hero.HP <= 0){
                    display.heroDead();
                    break loop;
                }

                display.cont();
            }

            //edge of map
            if (hero.coordinates.outOfBounds()){
                display.beatMap();
                break loop;
            }
        }
        return 0;
    }

    private void fight() {
        if (runAway()){
            return;
        }

        Enemy enemy = new Enemy("Enemy", 10,15,10,10);

        int damage = enemy.getAttack() - hero.getDefence();

        display.takeDamage(damage);
        hero.HP -= damage;

        if(hero.addExperience())
            display.levelUp();

    }


    private boolean runAway(){
        if (!display.startFight()){
            if (random.nextBoolean()){
                display.fightRunSuccess();
                return true;
            }
            display.fightRunFail();
        }
        return false;
    }



}

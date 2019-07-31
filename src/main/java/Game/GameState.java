package Game;

import Characters.Enemy;
import Characters.Hero;
import Display.*;
import Helper.FightResult;
import Helper.FileManipulation;
import Items.Armor;
import Items.Helm;
import Items.Item;
import Items.Weapon;
import lombok.Getter;

import java.util.Random;

public class GameState {

    private FileManipulation fm = new FileManipulation();

    public Hero getHero() {
        return hero;
    }

    //    @Getter
    private Hero hero;
//    @Getter
    private Map map;

    public Map getMap() {
        return map;
    }

    Random random = new Random();

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public void setHeroFromFile(String heroFileName) throws Exception{
        hero = fm.createFromFile(heroFileName);
    }
    public void initMap(){
        map = new Map(hero.getLevel());
        hero.coordinates.setMax(map.getSize());
        hero.centre();
    }

    public Hero heroFileInfo(String heroFileName){
        try {
            return fm.createFromFile(heroFileName);
        }
        catch (Exception e) {
            return null;
        }
    }

    /*
    0. Normal move
    1. Fight
    2. Game end / beat map
    3. Exit
     */
    public int move(String direction){
        switch (direction){
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
                return 3;
        }
        //edge of map
        if (hero.coordinates.outOfBounds()){
            return 2;
        }
        //fight?
        if (map.occupied(hero.getCoordinates())){
            return 1;
        }
        return 0;
    }

    public FightResult fight() {
        FightResult result = new FightResult();
        int mod = 0;

        Enemy enemy = createEnemy(hero.getLevel());
        int damage = 3;

        while(true) {
            int roll = random.nextInt(100);
            roll += mod;

            if ((hero.getAttack() + roll) > enemy.getDefence()) {
                //success
                break;
            }

            result.damageTaken += damage;
            hero.HP -= damage;

            mod += 33;
        }






        //always add exp? what about when dead
        if(hero.addExperience(enemy.experience))
            result.levelUp = true;
        else
            result.levelUp = false;

        //item drop
        if (random.nextBoolean()){
            result.itemDropped = randomItem(hero.getLevel());
            hero.addItems(result.itemDropped);
        }
        return result;
    }

    public boolean runAway(){
        return (random.nextBoolean());
    }

    public boolean saveHero() {
        try {
            fm.writeHeroToFile(hero, hero.getName());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Item randomItem(int heroLevel) {
        int value = heroLevel * 2 + 3;

        int rand = random.nextInt(3);
        switch (rand) {
            case 0:
                return new Armor(value);
            case 1:
                return new Helm(value);
            case 2:
                return new Weapon(value);
        }
        return null;
    }

    private Enemy createEnemy(int heroLevel){

        int experience = heroLevel * 200 + ((heroLevel - 1) * 100);
        int defence = heroLevel * 3;
        Enemy enemy = new Enemy("Enemy", 10,15, defence,10, experience);
        return enemy;
    }
}

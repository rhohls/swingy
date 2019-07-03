package Game;

import Characters.Enemy;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    int size;
    ArrayList<CoOrdinates> enemiesLocations;
    Random rand = new Random();

    Map(int heroLevel){
        size = (heroLevel - 1) * 5 + (10 - (heroLevel % 2));
        int numEnemies = (size * size) / 3;

//      Create list of enemies
        for (int i=0; i < numEnemies; i++)
        {
            CoOrdinates newCoords = new CoOrdinates(
                    rand.nextInt(size), rand.nextInt(size));
            while (occupied(newCoords))
            {
                newCoords = new CoOrdinates(
                        rand.nextInt(size), rand.nextInt(size));
            }
            enemiesLocations.add(newCoords);
        }
    }

    private boolean occupied(CoOrdinates coord){
        for (CoOrdinates co : enemiesLocations){
            if (co.getX() == coord.getX() && co.getY() == coord.getY())
                return true;
        }
        return false;
    }
}

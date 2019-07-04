package Game;

import Characters.Enemy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

public class Map {
    @Getter
    int size;

    ArrayList<CoOrdinates> enemiesLocations = new ArrayList<CoOrdinates>();
    Random rand = new Random();

    public Map(int heroLevel){
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

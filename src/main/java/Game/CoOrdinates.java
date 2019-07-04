package Game;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CoOrdinates {
    private int x;
    private int y;
    private int max;

    public CoOrdinates(int x, int y){
        this.x = x;
        this.y = y;
        this.max = -1;
    }

    public CoOrdinates(int x, int y, int max){
        this.x = x;
        this.y = y;
        this.max = max;
    }

    public int[] getArray(){
        return (new int[] {x,y});
    }

    public void setX(int newX){
        x = newX;

        //limit x to 0 and max
        if (x < 0)
            x = 0;
        if (max != -1 && x > max){
            x = max;
        }
    }

    public void setY(int newY){
        y = newY;

        //limit x to 0 and max
        if (y < 0)
            y = 0;
        if (max != -1 && y > max){
            y = max;
        }
    }
}

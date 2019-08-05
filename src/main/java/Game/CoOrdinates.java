package Game;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    public boolean outOfBounds(){
        if ((x <=0 || y <= 0) ||
            (x >= max || y >= max)){
            return true;
        }
         else {
            return false;
        }
    }
}

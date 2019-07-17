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

    //Allow above/below max for GameSwingUI win condition
//    public void setX(int newX){
//        x = newX;
//
//        //limit x to 0 and max
//        if (x < 0)
//            x = 0;
//        if (max != -1 && x > max){
//            x = max;
//        }
//    }
//
//    public void setY(int newY){
//        y = newY;
//
//        //limit x to 0 and max
//        if (y < 0)
//            y = 0;
//        if (max != -1 && y > max){
//            y = max;
//        }
//    }
}

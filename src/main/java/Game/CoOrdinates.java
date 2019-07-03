package Game;

public class CoOrdinates {
    private int x;
    private int y;

    CoOrdinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[] getArray(){
        return (new int[] {x,y});
    }
}

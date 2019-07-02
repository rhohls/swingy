public class CoOrdinates {
    int x;
    int y;

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

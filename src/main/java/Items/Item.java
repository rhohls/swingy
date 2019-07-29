package Items;

public class Item {
    public String name;
    public int value;

//    Item(){}

    Item(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}

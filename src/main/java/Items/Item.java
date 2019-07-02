package Items;

public class Item {
    String name;
    int value;

    Item(){}

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

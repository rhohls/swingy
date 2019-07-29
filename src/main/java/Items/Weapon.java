package Items;

public class Weapon extends Item {
    public Weapon(int value) {
        super("Sword", value);
    }

    public Weapon(String name, int value) {
        super(name, value);
    }
}

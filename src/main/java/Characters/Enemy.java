package Characters;



public class Enemy extends BasicCharacter{
    public int experience;

    public Enemy(String name, int HP, int attack, int defence, int maxHP, int experience) {
        super(name, maxHP, attack, defence, HP);
        this.experience = experience;
    }

}

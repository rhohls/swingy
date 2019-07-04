package Display;

import Characters.Hero;
import Game.Map;

public interface Display {
//    void mapOutput();

    void display(Hero hero, Map map);

    boolean startFight();

}

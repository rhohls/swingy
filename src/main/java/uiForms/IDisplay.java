package uiForms;

import Helper.FightResult;

import java.io.File;

public interface IDisplay {
    void openMainMenu(File[] fileList);

    void startGame();

    void updateDisplay();

    void displayFight();

    void displayWin();

    void runAwaySuccess();

    void runAwayFail();

    void fightResult(FightResult result);

    void heroDead();

    void failSave();
}

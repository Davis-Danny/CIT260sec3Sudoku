/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.menus;

import citbyui.cit260.sudoku.enums.MenuCommands;
import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.BEST_TIMES;
import static citbyui.cit260.sudoku.enums.Status.NEW_GAME;
import static citbyui.cit260.sudoku.enums.Status.PLAYING;
import citbyui.cit260.sudoku.exceptions.MenuException;
import sudoku.Board;
import sudoku.Play;

/**
 *
 * @author Scott
 */
public class NewGameMenu extends Menu {

    String difficulty;

    public NewGameMenu() {
        super(NewGameMenu.menuItems);

    }

    @Override
    public Status execute(String command) throws MenuException {
        switch (command) {
            case "E":
                difficulty = "E";
                break;
            case "M":
                difficulty = "M";
                break;
            case "H":
                difficulty = "H";
                break;

            default:
                throw new MenuException(NEW_GAME);

        }
        return PLAYING;

    }
    private final static String[][] menuItems = {
        {"E", "Easy"},
        {"M", "Medium"},
        {"H", "Hard"},
        {"Q", "Quit"}

    };

    public String getDifficulty() {
        return difficulty;
    }

}

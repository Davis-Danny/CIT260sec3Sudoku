/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.menus;

import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.BEST_TIMES;
import static citbyui.cit260.sudoku.enums.Status.MAIN_MENU;
import citbyui.cit260.sudoku.exceptions.MenuException;

/**
 *
 * @author Scott
 */
public class MainMenu extends Menu {

    public MainMenu() {
        super(MainMenu.menuItems);

    }
    private final static String[][] menuItems = {
        {"N", "New Game"},
        {"B", "Best Times"},
        {"?", "Help"},
        {"Q", "Quit"}
    };

    @Override
    public Status execute(String command) throws MenuException {

        switch (command) {

            case "N":
                return Status.NEW_GAME;
            case "B":
                return Status.BEST_TIMES;
            case "?":
                return Status.HELP;
            case "Q":
                return Status.EXIT;
            default:
                throw new MenuException(MAIN_MENU);
        }
    }

   
}

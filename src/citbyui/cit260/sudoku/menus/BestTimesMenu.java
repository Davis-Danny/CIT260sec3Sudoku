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
import citbyui.cit260.sudoku.menus.Menu;
import citbyui.cit260.sudoku.menus.MainMenu;

/**
 *
 * @author Jeff Smith
 */
public class BestTimesMenu extends Menu{
    
    public BestTimesMenu() {
        super(BestTimesMenu.menuItems);
    
    }
    
    private final static String[][] menuItems = {
        {"C", "Clear Times"},
        {"M", "Return To Main Menu"},
    };
    
    @Override
    public Status execute(String command)throws MenuException {
        switch (command) {
                
                case "C":
                    reset();
                    return BEST_TIMES;
                case "M":
                    return MAIN_MENU;
                default:
                    throw new MenuException(BEST_TIMES);
                    
            }
    }
    private static final int[] bestTimes = new int[5];
    public void reset() {
        bestTimes[0] = 180;
        bestTimes[1] = 120;
        bestTimes[2] = 90;
        bestTimes[3] = 60;
        bestTimes[4] = 30;
    }
    
    public void toMain() {
        MainMenu main = new MainMenu();
        main.getInput();
    }
}

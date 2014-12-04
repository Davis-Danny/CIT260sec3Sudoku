/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.menus;

import citbyui.cit260.sudoku.enums.MenuCommands;
import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.HELP;
import static citbyui.cit260.sudoku.enums.Status.MAIN_MENU;

/**
 *
 * @author Scott
 */
public class HelpMenu extends Menu {
    
    public HelpMenu() {
        super(HelpMenu.menuItems);
        
    }
    @Override
    public Status execute(String command) {
    
    switch (command) {
                case "I":
                    displayInstructions();
                    return HELP;
                    
                case "H":
                    displayHints();
                    return HELP;
                    
                case "Q":
                    return MAIN_MENU;
                    
                default:
                    System.out.println("Enter a valid command.");
                    return HELP;
            }    
    }
    private final static String[][] menuItems = {
        {"I", "Instructions"},
        {"H", "Hints"},
        {"Q", "Quit Help"}
    };
    
    public void displayInstructions(){
        System.out.println("Pick a square to enter a number from 1 – 9 that you believe goes in that spot."
            + " Continue until the squares are full and there are not any duplicate numbers in the rows, columns, or"
            + " 3x3 sub-grids. Once you have completed the grid, push the done button.");
    }
    
    public void displayHints() {
        System.out.println("Seek definites. When solving an easy Sudoku, the first thing you should do is look for definites."
            + "Definites are numbers that are definitely going to be there. Starting at 1, draw imaginary lines through boxes"
                + " in that 1's row and/or column. When there is only one box left in the 3x3 box, you know that is a definite."
                + " \";\n");
    }
}

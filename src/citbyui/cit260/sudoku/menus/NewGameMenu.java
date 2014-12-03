/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.menus;

import citbyui.cit260.sudoku.enums.MenuCommands;
import sudoku.Board;
import sudoku.Interface;

/**
 *
 * @author Scott
 */
public class NewGameMenu extends Menu {
    
    public NewGameMenu() {
        super(NewGameMenu.menuItems);
        
    }
    @Override
    public void execute(MenuCommands command) {
        switch (command) {
                case EASY:
                    System.out.println(easy);
                    
                    break;
                case MEDIUM:
                    System.out.println(medium);
                   
                    break;
                case HARD:
                    System.out.println(hard);
                    
                    break;
                
                default:
                    System.out.println("Pick a difficulty from above.");
                   
                    
            }
        Board board = new Board();
        difficulty = command;
        board.setBoard(command);
        Interface myInterface = new Interface();
        myInterface.runGame(board);
        
}
    private final static String[][] menuItems = {
        {"E", "Easy"},
        {"M", "Medium"},
        {"H", "Hard"},
        {"Q", "Quit"}
    
            
    };
    static String difficulty = "";
    static String easy = "This is the Easy Board Level!";
    static String medium = "This is the Medium Board Level!";
    static String hard = "This is the Hard Board Level!";
    
}



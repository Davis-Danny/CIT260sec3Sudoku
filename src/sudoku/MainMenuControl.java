/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Jeff Smith
 */
public class MainMenuControl {
    
    public void displayNewGame() {
        NewGameView mylevels = new NewGameView();
        mylevels.getdifficulty();
    }
    
    public void displayBestTimes() {
        System.out.println("Displays Best Times Menu");
    }
    
    public void displayHelp() {
        HelpMenuView myInput = new HelpMenuView();
        myInput.getInput();
    }
    
    public void displayQuit() {
        System.out.println("Displays Quit Menu");
    }
    
}

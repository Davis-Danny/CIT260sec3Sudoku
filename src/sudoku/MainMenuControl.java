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
        BestTimesView times = new BestTimesView();
        times.getInput();
    }
    
    public void displayHelp() {
        HelpMenuView myInput = new HelpMenuView();
        myInput.getInput();
    }
    
    public void displayPlayers(){
        players listPlayers = new players();
        listPlayers.displayPlayers();
        System.out.println("Searching for name...");
            listPlayers.searchName();
    }
    
    public void displayQuit() {
        ExitMenuView exit = new ExitMenuView();
        exit.getIntake();
    }
    
}

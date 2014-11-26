/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.menus;

import citbyui.cit260.sudoku.menus.ExitMenuView;

/**
 *
 * @author Jeff Smith
 */
public class MainMenuControl implements java.io.Serializable {
    
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
    
   
    
    public void displayQuit() {
        ExitMenuView exit = new ExitMenuView();
        exit.getIntake();
    }

    public MainMenuControl() {
    }
    
    

    @Override
    public String toString() {
        return "MainMenuControl{" + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

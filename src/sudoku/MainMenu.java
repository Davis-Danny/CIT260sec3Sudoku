/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

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
        {"H", "Help"},
        {"Q", "Quit"}
    };

    @Override
    public void execute(String command) {

        switch (command) {

            case "N":
                displayNewGame();
                break;
            case "B":
                displayBestTimes();
                break;
            case "H":
                displayHelp();
                break;

            case "Q":
                displayQuit();
                break;
            default:
                System.out.println("Enter a valid command");
        }
    }
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

}

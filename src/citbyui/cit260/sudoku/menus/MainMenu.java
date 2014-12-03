/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.menus;

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
            case "?":
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
        NewGameMenu mylevels = new NewGameMenu();
        mylevels.getInput();
    }
    
    public void displayBestTimes() {
        BestTimesMenu times = new BestTimesMenu();
        times.getInput();
    }
    
    public void displayHelp() {
        HelpMenu myInput = new HelpMenu();
        myInput.getInput();
    }
    
   
    
    public void displayQuit() {
        ExitMenuView exit = new ExitMenuView();
        exit.getIntake();
    }

}

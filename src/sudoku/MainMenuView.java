/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Jeff Smith
 */
public class MainMenuView {
    
    private final static String[][] menuItems = {
        {"N", "New Game"},
        {"B", "Best Times"},
        {"H", "Help"},
       {"P", "Players"},
        {"Q", "Quit"}
    };
    
    private final MainMenuControl mainMenuControl = new MainMenuControl();
    
    public void getInput() {
        
        String command;
        Scanner input = new Scanner(System.in);
        
        do {
            
            this.display();
            
            command = input.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                
                case "N":
                    mainMenuControl.displayNewGame();
                    break;
                case "B":
                    mainMenuControl.displayBestTimes();
                    break;
                case "H":
                    mainMenuControl.displayHelp();
                    break;
                case "P":
                    mainMenuControl.displayPlayers();
                    break;
                case "Q":
                    mainMenuControl.displayQuit();
                    break;
                default:
                    System.out.println("Enter a valid command");
            }
        }
        while (!command.equals("Q"));
    }    


    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < MainMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
}

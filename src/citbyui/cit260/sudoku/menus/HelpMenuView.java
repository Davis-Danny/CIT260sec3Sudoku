/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.menus;

import java.util.Scanner;

/**
 *
 * @author Jeff Smith
 */
public class HelpMenuView implements java.io.Serializable {
    
    private final static String[][] menuItems = {
        {"I", "Instructions"},
        {"H", "Hints"},
        {"Q", "Quit Help"}
    };
    
    private HelpMenuControl helpMenuControl = new HelpMenuControl();
    
    public void getInput() {
        
        String command;
        Scanner input = new Scanner(System.in);
        
        do {
            
            this.display();
            
            command = input.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "I":
                    helpMenuControl.displayInstructions();
                    break;
                    
                case "H":
                    helpMenuControl.displayHints();
                    break;
                    
                case "Q":
                    break;
                    
                default:
                    System.out.println("Enter a valid command.");
                    continue;
            }
         
         }
        while (!command.equals("Q"));
        
        return;
    }
    
        private void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < HelpMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
        
    
}
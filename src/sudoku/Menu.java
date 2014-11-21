/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Travis
 */
public abstract class Menu {
    private  static String[][] menuItems = null;
    
    
    public Menu (String[][] menuItems){
    this.menuItems=menuItems;}
            
    
    public void getInput() {
        
        String command;
        Scanner input = new Scanner(System.in);
        
        do {
            
            this.display();
            
            command = input.nextLine();
            command = command.trim().toUpperCase();
            
            execute(command);
        }
        while (!command.equals("Q"));
    }    
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
    
    public abstract void execute(String command);
     


    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Danny
 */
public class BestTimesView {
    
    
    
    private final static String[][] menuItems = {
        {"R", "Reset Times"},
        {"M", "Return To Main Menu"},
        {"Q", "Quit"},
    };
    
    private final BestTimesControl control = new BestTimesControl();
    
    public void getInput() {
        String command;
        Scanner input = new Scanner(System.in);
        
        do {
            
            
            control.showTimes();
            display();
            
            command = input.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                
                case "Q":
                    control.quit();
                    break;
                case "R":
                    control.reset();
                    break;
                case "M":
                    control.toMain();
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

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
}


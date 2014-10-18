package sudoku;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Scott Hidlebaugh
 */

public class ExitMenuView {
    private final static String[][] menuItems = {
        {"E", "Exit"},
        {"C", "Cancel"},
        
        
    };
    
    private ExitMenuControl ExitMenuControl = new ExitMenuControl();
    
    public void getIntake() {
        
        String command;
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        do {
            
            this.display();
            
            command = input.nextLine();
            command = command.trim().toUpperCase();
             
            switch (command) {
                case "E":
                    System.out.println(ExitMenuControl.exit);
                    repeat = false;
                    break;
                case "C":
                    System.out.println(ExitMenuControl.cancel);
                    repeat = false;
                    break;
                    
            }
            
         
         }
        while (repeat);

        
    }
    
        public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < ExitMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
}

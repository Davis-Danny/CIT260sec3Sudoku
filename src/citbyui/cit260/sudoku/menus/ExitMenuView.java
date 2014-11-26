package citbyui.cit260.sudoku.menus;

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
public class ExitMenuView implements java.io.Serializable{

    private final static String[][] menuItems = {
        {"E", "Exit"},
        {"C", "Cancel"},};

    

    public boolean getIntake() {

        String command;
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        do {

            this.display();

            command = input.nextLine();
            command = command.trim().toUpperCase();

            switch (command) {
                case "E":
                    System.out.println("The game will now exit.");
                    repeat = false;
                    return true;
                case "C":
                    System.out.println("Your game will now continue");
                    repeat = false;
                    return false;

            }

        } while (repeat);
        return false;
    }

    private void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < ExitMenuView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
}

package citbyui.cit260.sudoku.menus;

import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.BEST_TIMES;
import static citbyui.cit260.sudoku.enums.Status.EXIT;
import static citbyui.cit260.sudoku.enums.Status.MAIN_MENU;
import static citbyui.cit260.sudoku.enums.Status.QUIT;
import citbyui.cit260.sudoku.exceptions.MenuException;
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
public class ExitMenuView implements java.io.Serializable {

    private final static String[][] menuItems = {
        {"E", "Exit"},
        {"C", "Cancel"},};

    public Status getIntake() throws MenuException {

        String command;
        Scanner input = new Scanner(System.in);

        this.display();

        command = input.nextLine();
        command = command.trim().toUpperCase();

        switch (command) {
            case "E":
                System.out.println("The game will now exit.");
                return QUIT;
            case "C":
                System.out.println("Your game will now continue");
                return MAIN_MENU;
            default:
                throw new MenuException(EXIT);

        }

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

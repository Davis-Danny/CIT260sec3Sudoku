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
public class Interface {

    int x;
    int y;
    int value;
    String command;

    public void runGame(Board board) {
        board.displayGrid();
        Scanner input = new Scanner(System.in);
        while (!board.checkBoard()) {
            System.out.println("Column:");
            command = input.next();
            if("Q".equals(command)){
                ExitMenuView exit = new ExitMenuView();
                if(exit.getIntake()){
                    break;
                }
                else {
                    board.displayGrid();
                    continue;
                }
            }
            x = Integer.parseInt(command);
            if (x < 0 || x > 8) {
                System.out.println("ERROR: Invalid X value");
                continue;
            }
            System.out.println("Row:");
            y = Integer.parseInt(input.next());
            if (y < 0 || y > 8) {
                System.out.println("ERROR: Invalid Y value");
                continue;
            }
            System.out.println("Value:");
            value = Integer.parseInt(input.next());
            if (value < 0 || value > 9) {
                System.out.println("ERROR: Invalid value");
                continue;
            }
            board.addNumber(value, x, y);
            board.displayGrid();
        }
        if(board.checkBoard())System.out.println("Congratulations!");

    }
    
}

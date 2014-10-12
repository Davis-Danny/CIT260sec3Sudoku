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
    boolean invalid;

    public void runGame(Board board) {
        board.displayGrid();
        Scanner input = new Scanner(System.in);
        System.out.println(board.checkBoard());
        while (!board.checkBoard()) {
            invalid = true;
            while (invalid) {
                System.out.println("Column:");
                x = Integer.parseInt(input.next());
                if (x < 0 || x > 8) {
                    System.out.println("ERROR: Invalid X value");
                    invalid = true;
                    break;
                }
                System.out.println("Row:");
                y = Integer.parseInt(input.next());
                if (y < 0 || y > 8) {
                    System.out.println("ERROR: Invalid Y value");
                    invalid = true;
                    break;
                }
                System.out.println("Value:");
                value = Integer.parseInt(input.next());
                if (value < 1 || value > 9) {
                    System.out.println("ERROR: Invalid value");
                    invalid = true;
                    break;
                }
                invalid = false;
            }
            board.addNumber(value,x,y);
            board.displayGrid();
            System.out.println(board.checkBoard());
        }
        System.out.println("Congratulations!");

    }
}

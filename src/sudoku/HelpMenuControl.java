/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Jeff Smith
 */
public class HelpMenuControl implements java.io.Serializable{
    
    public void displayInstructions(){
        System.out.println("Pick a square to enter a number from 1 – 9 that you believe goes in that spot."
            + " Continue until the squares are full and there are not any duplicate numbers in the rows, columns, or"
            + " 3x3 sub-grids. Once you have completed the grid, push the done button.");
    }
    
    public void displayHints() {
        System.out.println("Seek definites. When solving an easy Sudoku, the first thing you should do is look for definites."
            + "Definites are numbers that are definitely going to be there. Starting at 1, draw imaginary lines through boxes"
                + " in that 1's row and/or column. When there is only one box left in the 3x3 box, you know that is a definite."
                + " \";\n");
    }
    
}
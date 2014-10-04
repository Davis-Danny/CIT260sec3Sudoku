/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Travis
 */
public class hints_hard {
    String hint_one = "Start at number 1. Use the same logic from an easy puzzle to fill in every empty box with all of the possible numbers for that box. If possible, put in definites.";
    String hint_two = "In a hard Sudoku, you won't be able to solve from the start, so just fill in what you know it could be. This will help later when you have two or three options per box and you can't remember what they are.";
    String hint_three = "Note that if two boxes in a block, column or row must be one of two numbers, you can use those numbers to eliminate other possibilities.";
public void showHints () {
    System.out.println(hint_one);
}
}


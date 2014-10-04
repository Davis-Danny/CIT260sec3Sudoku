/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author TJ Webster
 */
public class hints_easy {
    String hint_one = "Seek definites. When solving an easy Sudoku, the first thing you should do is look for definites. Definites are numbers that are definitely going to be there. Starting at 1, draw imaginary lines through boxes in that 1's row and/or column. When there is only one box left in the 3x3 box, you know that is a definite. ";
    String hint_two = "Work your way through the numbers until 9. Since you have filled in some numbers, this should help get other numbers that had more than one possibility before.";
    String hint_three = "If you get stuck, go back and make sure to look at everything. It is almost guaranteed you missed something. That one number is usually all you need to get going again. If you still cannot find any solutions, start labeling every block with every number that could possibly go in that box.";
    
public void showHints () {
    System.out.println(hint_one);
}
}



 

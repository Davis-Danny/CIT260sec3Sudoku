/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author TJ Webster
 */
public class hints {
    String easy_hint_one = "Seek definites. When solving an easy Sudoku, the first thing you should do is look for definites. Definites are numbers that are definitely going to be there. Starting at 1, draw imaginary lines through boxes in that 1's row and/or column. When there is only one box left in the 3x3 box, you know that is a definite. ";
    String easy_hint_two = "Work your way through the numbers until 9. Since you have filled in some numbers, this should help get other numbers that had more than one possibility before.";
    String easy_hint_three = "If you get stuck, go back and make sure to look at everything. It is almost guaranteed you missed something. That one number is usually all you need to get going again. If you still cannot find any solutions, start labeling every block with every number that could possibly go in that box.";
  
    String hard_hint_one = "Start at number 1. Use the same logic from an easy puzzle to fill in every empty box with all of the possible numbers for that box. If possible, put in definites.";
    String hard_hint_two = "In a hard Sudoku, you won't be able to solve from the start, so just fill in what you know it could be. This will help later when you have two or three options per box and you can't remember what they are.";
    String hard_hint_three = "Note that if two boxes in a block, column or row must be one of two numbers, you can use those numbers to eliminate other possibilities.";

    NewGame mylevels = new NewGame();
   

    /**
     *
     * @return 
     */
    
    public String inquireHint(String level) { 
      Scanner input = new Scanner(System.in);
      
      System.out.println("Would you like a hint?");
      String answer="";
       answer = input.next();
      if("yes".equals(answer)) {
//          return getHints(mylevels.level());
          if(mylevels.easy.equals(level) || mylevels.medium.equals(level))
            return easy_hint_one;
          else if(mylevels.hard.equals(level))
              return hard_hint_one;
          else 
              return "Error: Difficulty was not chosen";
      } else {
          return "Well ok then";
      }
       
}
         
   
//    public String getHints(String level) {         
       
          
  }

    







 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Danny Davis
 */
public class Sudoku {

    String playerName;
    String instructions = "Pick a square to enter a number from 1 – 9 that you believe goes in that spot."
            + " Continue until the squares are full and there are not any duplicate numbers in the rows, columns, or"
            + " 3x3 sub-grids. Once you have completed the grid, push the done button.";

    public static void main(String[] args) {
        Sudoku myGame = new Sudoku();
        myGame.getName();
        myGame.getHelp();
        bestTimes myTimes = new bestTimes();
        myTimes.showTimes();
        NewGame mylevels = new NewGame();
        mylevels.level();
        
        myGame.getHints();
    }

    public void getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        playerName = input.next();
        
    }
    public void getHelp(){
        System.out.println(instructions);
    }
  public void getHints() {
      hints_easy myHints1 = new hints_easy();
      hints_hard myHints2 = new hints_hard();
      Scanner input = new Scanner(System.in);
      
      System.out.println("Would you like a hint?");
      String answer = input.next();
      if("yes".equals(answer)) {
          System.out.println("What difficulty are you on?");
          String difficulty = input.next();
          if("easy".equals(difficulty) || "medium".equals(difficulty))
            myHints1.showHints();
          else if("hard".equals(difficulty))
              myHints2.showHints();
          else 
              System.out.println("That was not a choice in difficulty");
}
      else
          System.out.println("Well ok then");
          
      
          
          
          
            
      
  
          
          
      
  }
}

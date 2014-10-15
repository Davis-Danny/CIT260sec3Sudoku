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
        
        HelpMenuView myInput = new HelpMenuView();
        myInput.getInput();
        
        System.out.println(myGame.pastGames(8, 8));
        bestTimes myTimes = new bestTimes();
        myTimes.showTimes();
        /*
        bestTimes easyTimes = new bestTimes();
        int times[] = new int[3];
        times[0] = 1255;
        times[1] = 3005;
        times[2] = 2547;
        System.out.println(easyTimes.getBestEasyTime(times));
        */
        NewGame mylevels = new NewGame();
        mylevels.level();        
        hints myHints = new hints();
        System.out.println(myHints.inquireHint(mylevels.level()));
      
        Timer myTimer = new Timer();        
        System.out.println(myTimer.addTime(7));
        Exit exit = new Exit();
        exit.quit();        
    }

    public void getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        playerName = input.next();
        
    }
//    public void getHelp(){
//        System.out.println(instructions);
//    }
    
    public String pastGames(int complete, int incomplete){
        int totalGames = complete + incomplete;
        int ratioGames = (complete / totalGames) * 100;
        if (complete <= 0 && incomplete > 0)
          return "You have " + incomplete + " incomplete games \n" + "You have completed " + ratioGames+ "%"+ " of your games";
                    
        else if (complete > 0 && incomplete > 0)
            return "You have completed " + complete + " games \n" +
             "You have " + incomplete + " incomplete games \n" + "You have completed " + ratioGames+ "%"+ " of your games";
        else if (complete > 0)
            return "You have completed " + complete + " games \n" + "You have completed " + ratioGames+ "%"+ " of your games";
        else if(complete <= 0)
            return "You have not completed any games \n" + "You have completed " + ratioGames+ "%"+ " of your games";
        else
            return "Error:Number is not positive";
       
        
    }
  
}

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
    }

    public void getName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        playerName = input.next();
        
    }
    public void getHelp(){
        System.out.println(instructions);
    }

}

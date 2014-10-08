/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;


/**
 *
 * @author Scott Hidlebaugh
 */
public class Exit {
    String exit = "Are you sure you want to exit? (Y/N)";
    
    public void quit(){
        boolean valid = false;
        while (!valid){  // valid == false
            System.out.println(exit);
            String answer="None";
            Scanner input = new Scanner(System.in);
            answer=input.next();
            switch (answer){
                case "y":
                case "Y": 
                    valid = true;
                    System.out.println("Outta here");
                    break;
                case "n":
                case "N":
                    valid = true;
                    System.out.println("Lemme back in");
                    break;
                default:
                    System.out.println("Please choose Y or N");
                    break;
            }
        
        
                
        }
    }
}

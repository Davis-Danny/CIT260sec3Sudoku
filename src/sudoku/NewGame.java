/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;


/**
 *
 * @author Heidi Spackman
 */
public class NewGame {
    String easy = "This is the Easy Board Level!";
    String medium = "This is the Medium Board Level!";
    String hard = "This is the Hard Board Level!";
    
      
    public void level() {
        String answer;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your chosen difficulty level: (easy, medium, hard): ");
        answer="No Answer";
        answer=input.next();
        if("easy".equals(answer)) 
        System.out.println(easy);
        else if("medium".equals(answer))
        System.out.println(medium);
        else if("hard".equals(answer))
        System.out.println(hard);
        else
            System.out.println("Pick a difficulty from above.");
        
                         }   
    
    }   

    

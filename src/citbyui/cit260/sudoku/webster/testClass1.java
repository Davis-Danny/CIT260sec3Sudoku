/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.webster;

import citbyui.cit260.sudoku.enums.MenuCommands;
import citbyui.cit260.sudoku.interfaces.DisplayInfo;
import citbyui.cit260.sudoku.interfaces.EnterInfo;
import java.util.Scanner;
import citbyui.cit260.sudoku.enums.Webster;
import static citbyui.cit260.sudoku.enums.Webster.FIRSTNAME;
/**
 *
 * @author webster
 */



public class testClass1 implements DisplayInfo, EnterInfo{
    
    public void getInput() {
        
        String command;
        Scanner input = new Scanner(System.in);
        
       
            
            this.display();
            
            command = input.nextLine();
            command = command.trim().toUpperCase();
            
            execute(command);
        
    }    
    public void execute(Webster command) {
    
    switch (command) {
                case FIRSTNAME:
                    
                    break;
                    
                case LASTNAME:
                    
                    break;
                    
                case PHONENUMBER:
                    break;
                    
                case BIRTHDATE:
                    break;    
                    
                default:
                    System.out.println("Enter a valid command.");
            }    
    }
    
    public void display(){
       Webster.FIRSTNAME.display();
       Webster.LASTNAME.display();
       Webster.PHONENUMBER.display();
       Webster.BIRTHDATE.display();
       
    }

    private void execute(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
}
   

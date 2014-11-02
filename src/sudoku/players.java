/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Travis
 */

public class players {
    String name;
    int i = 0;
    String[] pastNames = {"Calli", "Scott", "Danny", "Jeff", "Frank"  };
    int k;
    
    

    
    
    
   
        
            
//      public void fillNumbers() {
//            String numbers[] = new String[100];
//            for(k = 0;k > numbers.length;k++){
//               numbers[k]= Integer.toString(k);
//               return;
//           }
//} 
      public void recordName() {
//        fillNumbers();  
        Scanner input = new Scanner(System.in);
            System.out.println("Enter your name:");
            name = input.next();
        
            if (!name.replaceAll("[0-9]", "").equals(name)) {
            System.out.println("Please only enter letters");
            startOver();
        }
        else {
            pastNames[4] = name;
////            displayPlayers();
//            System.out.println("Searching for name...");
//            searchName();
        }
            
            
        
      }
            
     public void startOver () {
         recordName();
     }   
   
    public void displayPlayers() {
        System.out.println("Past Players are:");
        int playerNumber[] = new int[5];
        int p = 0;
        int j = 1;
        
        
        for(int t = 0; t < pastNames.length; t++) {
            playerNumber[p] = j;
            System.out.println(playerNumber[p] + "." + " " + pastNames[t]);
            p++;
            j++;
    }
    }
      public void searchName() {
        boolean found = false;
        for(String x: pastNames) {
            if(x=="TJ") {
                found = true;
                break;
            }
            }
            if(found)
                System.out.println("Name found!");
            else
                System.out.println("Name not found");
        }
}

    
    


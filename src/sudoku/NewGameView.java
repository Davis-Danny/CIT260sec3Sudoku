package sudoku;


import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Travis
 */
public class NewGameView {
    private final static String[][] menuItems = {
        {"E", "Easy"},
        {"M", "Medium"},
        {"H", "Hard"},
        {"Q", "Quit"}
        
    };
    
    private NewGameControl NewGameControl = new NewGameControl();
    
    public void getdifficulty() {
        
        String command;
        Scanner input = new Scanner(System.in);
        boolean repeat = true;
        do {
            
            this.display();
            
            command = input.nextLine();
            command = command.trim().toUpperCase();
             
            switch (command) {
                case "E":
                    System.out.println(NewGameControl.easy);
                    repeat = false;
                    break;
                case "M":
                    System.out.println(NewGameControl.medium);
                    repeat = false;
                    break;
                case "H":
                    System.out.println(NewGameControl.hard);
                    repeat = false;
                    break;
                default:
                    System.out.println("Pick a difficulty from above.");
                    continue;
                    
            }
            
         
        }
        while (repeat);

        NewGameControl.difficulty = command;
        Board board = new Board();
        board.setBoard(command);
        Interface myInterface = new Interface();
        myInterface.runGame(board);
        
        
        while (!command.equals("Q"));
        
        return;
    }
    
        public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (int i = 0; i < NewGameView.menuItems.length; i++) {
            System.out.println("\t   " + menuItems[i][0] + "\t" + menuItems[i][1]);
        }
        System.out.println("\t===============================================================\n");
    }
        
    
}

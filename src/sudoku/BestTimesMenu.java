/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Jeff Smith
 */
public class BestTimesMenu extends Menu{
    
    public BestTimesMenu() {
        super(BestTimesMenu.menuItems);
    
    }
    
    private final static String[][] menuItems = {
        {"R", "Reset Times"},
        {"M", "Return To Main Menu"},
    };
    
    @Override
    public void execute(String command) {
        switch (command) {
                
                case "R":
                    reset();
                    break;
                case "M":
                    toMain();
                    break;
                default:
                    System.out.println("Enter a valid command");
            }
    }
    private static final int[] bestTimes = new int[5];
    public void reset() {
        bestTimes[0] = 180;
        bestTimes[1] = 120;
        bestTimes[2] = 90;
        bestTimes[3] = 60;
        bestTimes[4] = 30;
    }
    
    public void toMain() {
        MainMenu main = new MainMenu();
        main.getInput();
    }
}

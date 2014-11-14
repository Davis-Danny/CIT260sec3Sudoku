/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Danny
 */
public final class BestTimesControl implements java.io.Serializable{
    
   private static final int[] bestTimes = new int[5];
    
    public BestTimesControl() {
        reset();
    }

    public void reset() {
        bestTimes[0] = 180;
        bestTimes[1] = 120;
        bestTimes[2] = 90;
        bestTimes[3] = 60;
        bestTimes[4] = 30;
    }

    public void printBestTimes(){
        sortBestTimes();
        for(int i:bestTimes){
            System.out.format("%02d:%02d%n", i/60, i%60);
            
        }
    }

    public void quit() {
        ExitMenuView exit = new ExitMenuView();
        exit.getIntake();
    }

    public void toMain() {
        MainMenuView main = new MainMenuView();
        main.getInput();
    }
    
    private void sortBestTimes() {
        for (int j = 0; j <= 3; j++) {
            for (int i = j+1; i <= 4; i++) {
                if (bestTimes[j] > bestTimes[i]) {
                    int temp = bestTimes[i];
                    bestTimes[i] = bestTimes[j];
                    bestTimes[j] = temp;
                }
               
            }
        }
    }
    public void addTime(int newTime){
        sortBestTimes();
        if(newTime<bestTimes[4]){
            bestTimes[4] = newTime;
            System.out.println("Congatulations! You got a new best time!");
            printBestTimes();
        }
    }
}

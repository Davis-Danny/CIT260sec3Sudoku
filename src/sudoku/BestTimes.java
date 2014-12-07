/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import citbyui.cit260.sudoku.exceptions.TimeException;

/**
 *
 * @author Jeff and Danny
 */
public final class BestTimes {
    
    private static final int[] bestTimes = new int[5];
    
    public BestTimes() {
        reset();
    }

    public void reset() {
        bestTimes[0] = 180;
        bestTimes[1] = 120;
        bestTimes[2] = 90;
        bestTimes[3] = 60;
        bestTimes[4] = 30;
        bestTimes[5] = 2;
    }

    public void printBestTimes(){
        sortBestTimes();
        for(int i:bestTimes){
            System.out.format("%02d:%02d%n", i/60, i%60);
            
        }
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
    public void addTime(int newTime)throws TimeException{
        sortBestTimes();
        if(newTime<bestTimes[4]){
            bestTimes[4] = newTime;
            System.out.println("Congatulations! You got a new best time!");
            printBestTimes();
        }
        else if(newTime<bestTimes[5]) {
            throw new TimeException("The was an error with your new time...sorry");
    }
    }
    
}

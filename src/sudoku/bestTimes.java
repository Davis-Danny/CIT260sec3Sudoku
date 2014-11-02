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
public class bestTimes {

    int[] bestTimes = new int[5];

    public void bestTimes() {
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
        for(int i = 0;i<5;i++){
            System.out.format("%02d:%02d%n", bestTimes[i]/60, bestTimes[i]%60);
            
        }
    }

    /**
    *
    *   @author Jeff
    */
    public String getBestMediumTime(int times[]) {
        int minutes, seconds;
        int bestTime = times[0];
        String bestTimeMessage;

        for (int i = 0; i < times.length - 1; i++) {
            if (times[i] < 0) {
                System.out.println("Invalid Time Entered");
            }
        }
        
        for (int i = 0; i < times.length - 1; i++) {
            if (bestTime > times[i + 1]) {
                bestTime = times[i + 1];
            }
        }
        minutes = bestTime / 60;
        seconds = bestTime % 60;
        bestTimeMessage = "Your best time on medium is:\n" + "\"" + minutes + ":" + seconds + "\"";
        return bestTimeMessage;
    }
    
    public int getTotalEasyTime(int times[]) {
        
        int totalEasyTime = 0;
        
        for (int i = 0; i < times.length - 1; i++) {
            if (times[i] < 0) {
                System.out.println("Invalid Time Entered");
            }
        }
        
        for (int i : times) {
            totalEasyTime += i;
        }
        
        return totalEasyTime;
    }

    public void sortBestTimes() {
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
}

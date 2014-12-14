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
        bestTimes[0] = 1800;
        bestTimes[1] = 1200;
        bestTimes[2] = 900;
        bestTimes[3] = 600;
        bestTimes[4] = 300;
    }

    public String[] getBestTimes() {
        String output[] = new String[5];
        sortBestTimes();
        for (int c = 0; c < bestTimes.length; c++) {
            int i = bestTimes[c];
            String line = "   " + (c + 1) + ": ";

            if ((i / 360) < 10) {
                line += "0";
            }
            line += i / 360 + ":";

            if (((i % 360) / 60) < 10) {
                line += "0";
            }
            line += (i % 360) / 60;
            output[c] = line;
        }
        return output;
    }

    private void sortBestTimes() {
        for (int j = 0; j <= 3; j++) {
            for (int i = j + 1; i <= 4; i++) {
                if (bestTimes[j] > bestTimes[i]) {
                    int temp = bestTimes[i];
                    bestTimes[i] = bestTimes[j];
                    bestTimes[j] = temp;
                }

            }
        }
    }
//    public void addTime(int newTime)throws TimeException{
//        sortBestTimes();
//        if(newTime<bestTimes[4]){
//            bestTimes[4] = newTime;
//            System.out.println("Congatulations! You got a new best time!");
//            printBestTimes();
//        }
//        else if(newTime<bestTimes[5]) {
//            throw new TimeException("The was an error with your new time...sorry");
//    }
//    }

}

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
    String time1 = "Not yet taken!";
    String time2 = "Not yet taken!";
    String time3 = "Not yet taken!";
    String time4 = "Not yet taken!";
    String time5 = "Not yet taken!";
    
    public void showTimes(){
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);
        System.out.println(time5);
    }
    public String getBestEasyTime(int times[]) {
        int minutes, seconds;
        int bestTime = times[0];
        String bestTimeMessage;
                
        for(int i = 0; i < times.length - 1; i++) {
            if(bestTime > times[i + 1])
                bestTime = times[i + 1];
        }
        minutes = bestTime / 60;
        seconds = bestTime % 60;
        bestTimeMessage = "Your best time on easy is:\n" + "\"" + minutes + ":" + seconds + "\"";
        return bestTimeMessage;
    }
}

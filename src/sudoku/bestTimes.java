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
    String time1;
    String time2;
    String time3;
    String time4;
    String time5;
    
    public void bestTimes(){
        reset();
    }

    public void reset() {
    time1 = "Not yet taken!";
    time2 = "Not yet taken!";
    time3 = "Not yet taken!";
    time4 = "Not yet taken!";
    time5 = "Not yet taken!";
    }

    public void showTimes() {
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);
        System.out.println(time5);
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
}

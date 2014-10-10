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
public class Timer {
    int seconds;
    int minutes;
    
    public String addTime(int newSeconds){
        seconds = seconds + newSeconds;
        if(seconds>=60){
            seconds = 0;
            minutes++;
        }
        return minutes + ":" + seconds;
    }
}

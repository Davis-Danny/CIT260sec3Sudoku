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
    int hours;
    
    public String addTime(int newSeconds){
        String gameTime = "";
        if(newSeconds<0){
            return "ERROR: input a positive number.";
        }
        seconds = seconds + newSeconds;
        while(seconds>=60){
            seconds -= 60;
            minutes++;
        }
        while(minutes>=60){
            minutes -= 60;
            hours++;
        }
        if(hours>0){
            gameTime += hours + ":";
        }
        if(minutes<10){
            gameTime += 0;
        }
        gameTime += minutes + ":";
        if(seconds<10){
            gameTime += 0;
        }
        gameTime += seconds;
        return gameTime;
    }
}

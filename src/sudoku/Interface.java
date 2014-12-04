/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.MAIN_MENU;
import static citbyui.cit260.sudoku.enums.Status.PLAYING;
import static citbyui.cit260.sudoku.enums.Status.QUIT;
import citbyui.cit260.sudoku.menus.BestTimesMenu;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Danny
 */
public class Interface implements java.io.Serializable {

    private int x;
    private int y;
    private int value;
    String command;

    public Status runGame(Board board) {
        boolean repeat = true;
        Timer timer = new Timer();
        int time = 0;
        SecondTask add = new SecondTask(time);
        timer.scheduleAtFixedRate(add, 0, 1000);

        board.displayGrid();
        Scanner input = new Scanner(System.in);
        while (repeat) {
            if(board.playGrid()==PLAYING){
                repeat = true;
            }
            else{
                return QUIT;
            }
            time = add.getTime();
            System.out.format("%02d:%02d%n", time / 60, time % 60);
            if(board.checkBoard()) break;
        }
        if (board.checkBoard()) {
            System.out.println("Congratulations!");
            BestTimesMenu times = new BestTimesMenu();
            return MAIN_MENU;
            //times.addTime(time);
        }
        
        return QUIT;

    }

    private static class SecondTask extends TimerTask {

        private int time;

        public SecondTask(int time) {
            this.time = time;
        }

        @Override
        public void run() {
            time++;
        }

        public int getTime() {
            return time;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

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

    public void runGame(Board board) {
        boolean repeat = true;
        Timer timer = new Timer();
        int time = 0;
        SecondTask add = new SecondTask(time);
        timer.scheduleAtFixedRate(add, 0, 1000);

        board.displayGrid();
        Scanner input = new Scanner(System.in);
        while (repeat) {
            repeat = board.playGrid();
            time = add.getTime();
            System.out.format("%02d:%02d%n", time / 60, time % 60);
            if(board.checkBoard()) break;
        }
        if (board.checkBoard()) {
            System.out.println("Congratulations!");
            BestTimesControl times = new BestTimesControl();
            times.addTime(time);
        }

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

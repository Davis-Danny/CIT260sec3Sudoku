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
public class Interface {

    private int x;
    private int y;
    private int value;
    String command;

    public void runGame(Board board) {
        Timer timer = new Timer();
        int time = 0;
        SecondTask add = new SecondTask(time);
        timer.scheduleAtFixedRate(add, 0, 1000);

        board.displayGrid();
        Scanner input = new Scanner(System.in);
        while (!board.checkBoard()) {
            System.out.println("Column:");
            command = input.next();
            command = command.trim().toUpperCase();
            if ("Q".equals(command)) {
                ExitMenuView exit = new ExitMenuView();
                if (exit.getIntake()) {
                    break;
                } else {
                    board.displayGrid();
                    continue;
                }
            }
            x = Integer.parseInt(command);
            if (x < 0 || x > 8) {
                System.out.println("ERROR: Invalid X value");
                continue;
            }
            System.out.println("Row:");
            y = Integer.parseInt(input.next());
            if (y < 0 || y > 8) {
                System.out.println("ERROR: Invalid Y value");
                continue;
            }
            System.out.println("Value:");
            value = Integer.parseInt(input.next());
            if (value < 0 || value > 9) {
                System.out.println("ERROR: Invalid value");
                continue;
            }
            board.addNumber(value, x, y);
            board.displayGrid();
            time = add.getTime();
            System.out.format("%02d:%02d%n", time / 60, time % 60);
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

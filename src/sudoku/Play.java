/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.*;
import citbyui.cit260.sudoku.exceptions.BoardException;
import citbyui.cit260.sudoku.exceptions.ExitException;
import citbyui.cit260.sudoku.menus.BestTimesMenu;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Danny
 */
public class Play implements java.io.Serializable {

    String command;

    public Status runGame(Board board) throws ExitException{
        boolean repeat = true;
        final Timer timer = new Timer();
        int time = 0;
        final SecondTask add = new SecondTask(time);
        timer.scheduleAtFixedRate(add, 0, 1000);

        board.displayGrid();
        while (repeat) {
            try{
                board.playGrid();
            }
            catch(BoardException e){
                System.out.println(e.getMessage());
                timer.cancel();
                timer.purge();
                continue;
            }
            time = add.getTime();
            System.out.format("%02d:%02d%n", time / 60, time % 60);
            if (board.checkBoard()) {
                break;
            }
        }
        if (board.checkBoard()) {
            System.out.println("Congratulations!");
            BestTimesMenu times = new BestTimesMenu();
            timer.cancel();
            timer.purge();
            return MAIN_MENU;
            //times.addTime(time);
        }

        return QUIT;

    }
    
    
    private static final class SecondTask extends TimerTask {

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

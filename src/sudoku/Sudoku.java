/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.MAIN_MENU;
import static citbyui.cit260.sudoku.enums.Status.QUIT;
import citbyui.cit260.sudoku.exceptions.ExitException;
import citbyui.cit260.sudoku.exceptions.MenuException;
import citbyui.cit260.sudoku.frames.MainFrame;
import citbyui.cit260.sudoku.menus.BestTimesMenu;
import citbyui.cit260.sudoku.menus.ExitMenuView;
import citbyui.cit260.sudoku.menus.HelpMenu;
import citbyui.cit260.sudoku.menus.MainMenu;
import citbyui.cit260.sudoku.menus.NewGameMenu;

/**
 *
 * @author Danny Davis
 */
public class Sudoku implements java.io.Serializable {

    private static MainFrame mainFrame;
    private Status status;

    public static void main(String[] args) throws MenuException {

        Sudoku sudoku = null;
        try {
            sudoku = new Sudoku(MAIN_MENU);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    Sudoku.mainFrame = new MainFrame();

                    Sudoku.mainFrame.setVisible(true);
                }
            });

            //takeAction(Status.MAIN_MENU);

        } catch (Throwable ex) {
            System.out.println("Unexpected error:" + ex.getMessage());
            System.out.println(ex.getStackTrace().toString());
        } finally {
            if (Sudoku.mainFrame != null) {
                Sudoku.mainFrame.dispose();
            }
        }
    }

    public Sudoku(Status status) {

    }

    public void takeAction(Status status) throws MenuException {

        String difficulty;
        Board board = new Board();

        while (status != QUIT) {
            switch (status) {
                case MAIN_MENU:
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            Sudoku.mainFrame = new MainFrame();

                            Sudoku.mainFrame.setVisible(true);
                        }
                    });

                    MainMenu mainMenu = new MainMenu();
                    status = mainMenu.getInput();
                    break;

                case NEW_GAME:
                    NewGameMenu mylevels = new NewGameMenu();
                    status = mylevels.getInput();
                    difficulty = mylevels.getDifficulty();
                    board = new Board();
                    board.setBoard(difficulty);
                    break;

                case BEST_TIMES:
                    BestTimesMenu times = new BestTimesMenu();
                    status = times.getInput();
                    break;

                case PLAYING:
                    Play myInterface = new Play();
                    try {
                        status = myInterface.runGame(board);
                    } catch (ExitException e) {
                        ExitMenuView exit = new ExitMenuView();
                        status = exit.getIntake();
                        if (status == MAIN_MENU) {
                            status = e.getOldStatus();
                        }
                    }
                    break;

                case HELP:
                    HelpMenu myInput = new HelpMenu();
                    status = myInput.getInput();
                    break;

                case EXIT:
                    ExitMenuView exit = new ExitMenuView();
                    status = exit.getIntake();

            }
        }
    }

}

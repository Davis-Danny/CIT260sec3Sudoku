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
import citbyui.cit260.sudoku.frames.*;
import citbyui.cit260.sudoku.menus.BestTimesMenu;
import citbyui.cit260.sudoku.menus.ExitMenuView;
import citbyui.cit260.sudoku.menus.HelpMenu;
import citbyui.cit260.sudoku.menus.MainMenu;
import citbyui.cit260.sudoku.menus.NewGameMenu;
import java.awt.Frame;

/**
 *
 * @author Danny Davis
 */
public class Sudoku implements java.io.Serializable {

    private static MainFrame mainFrame;
    private static String difficulty = null;

    public static void main(String[] args) throws MenuException {

        try {
            takeAction(Status.MAIN_MENU);

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

    public static void takeAction() throws MenuException {
        takeAction(MAIN_MENU);
    }

    public static void takeAction(Status status, String setDifficulty) throws MenuException {
        difficulty = setDifficulty;
        takeAction(status);
    }

    public static void takeAction(Status status) throws MenuException {

        Board board = new Board();

        while (status != QUIT) {
            switch (status) {
                case MAIN_MENU:
                    displayFrame(new MainFrame());
                    return;

                case NEW_GAME:
                    displayFrame(new NewGameFrame());
                    return;

                case BEST_TIMES:
                    displayFrame(new BestTimesFrame());
                    return;

                case PLAYING:
                    board.setBoard(difficulty);
                    displayFrame(new PlayFrame(board));
                    return;

                case HELP:
                    displayFrame(new HelpFrame());
                    return;

                case EXIT:
                    displayFrame(new ExitFrame());
                    return;
                case CONGRATS:
                    displayFrame(new CongratsFrame());
                    return;

            }
        }
    }

    private static void displayFrame(final SuperFrame frame) {
        try {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    frame.setVisible(true);
                }
            });
        } catch (Throwable ex) {
            System.out.println("Unexpected error:" + ex.getMessage());
            System.out.println(ex.getStackTrace().toString());
        } 
    }
}


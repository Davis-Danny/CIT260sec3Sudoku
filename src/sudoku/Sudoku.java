/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import citbyui.cit260.sudoku.enums.Status;
import static citbyui.cit260.sudoku.enums.Status.QUIT;
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

    public static void main(String[] args) {

        takeAction(Status.MAIN_MENU);

    }

    public static void takeAction(Status status) {

        String difficulty;
        Board board = new Board();

        while (status != QUIT) {
            switch (status) {
                case MAIN_MENU:
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
                    Interface myInterface = new Interface();
                    status = myInterface.runGame(board);
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

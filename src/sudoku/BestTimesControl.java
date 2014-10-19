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
public class BestTimesControl {

    String time1 = "Not yet taken!";
    String time2 = "Not yet taken!";
    String time3 = "Not yet taken!";
    String time4 = "Not yet taken!";
    String time5 = "Not yet taken!";

    public void BestTimesControl() {
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

    public void quit() {
        ExitMenuView exit = new ExitMenuView();
        exit.getIntake();
    }

    public void toMain() {
        MainMenuView main = new MainMenuView();
        main.getInput();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.enums;

/**
 *
 * @author tjwebster
 */
public enum Status {
    MAINMENU("MAINMENU"),
    NEW_GAME("NEW_GAME"),
    PLAYING("PLAYING"),
    HELP("HELP"),
    BEST_TIMES("BEST_TIMES"),
    EXIT("EXIT");
    
    String value;
    
    Status(String value) {
        this.value = value;
        
    }
    
    public String getValue() {
        return value;
    }
}

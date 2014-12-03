/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.enums;

/**
 *
 * @author Jeff
 */
public enum MenuCommands {
    
    MAIN ("R"),
    EASY ("E"),
    MEDIUM ("M"),
    HARD ("H"),
    HELP ("?"),
    NEW_GAME ("N"),
    BEST_TIMES ("B"),
    INSTRUCTIONS ("I"),
    QUIT ("Q");
    
    String value;
    
    MenuCommands(String value) {
        this.value=value;
    }
    
    public String getValue() {
        return value;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.exceptions;

import citbyui.cit260.sudoku.enums.Status;

/**
 *
 * @author tjwebster
 */
public class MenuException extends Exception {
    
    Status errorStatus;
    public MenuException(Status status){
        errorStatus = status;
    }
    
    public Status getErrorStatus(){
        return errorStatus;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.exceptions;

import citbyui.cit260.sudoku.enums.Status;

/**
 *
 * @author Danny
 */
public class ExitException extends Exception{
    
    Status oldStatus;
    public ExitException(Status status){
        oldStatus = status;
    }
    
    public Status getOldStatus(){
        return oldStatus;
    }
}

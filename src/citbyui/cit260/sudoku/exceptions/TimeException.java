/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.sudoku.exceptions;

/**
 *
 * @author Travis
 */
public class TimeException extends Exception{
   public TimeException() {
    
}

public TimeException(String message) {
    super(message);
}
public TimeException(String message, Throwable cause) {
    super(message, cause);
}
public TimeException(Throwable cause) {
    super(cause);
}    
}

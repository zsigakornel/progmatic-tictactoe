package com.progmatic.tictactoeexam.exceptions;

/**
 * An exception thrown when a cell-related problem happens.
 * @author pyppgergely
 */
public class CellException extends Exception{
    /**
     * Row index of the problematic cell.
     */
    private final int row;
    /**
     * Column index of the problematic cell.
     */
    private final int column;
    /**
     * A message describing the specific problem with this cell.
     */
    private final String message;

    public CellException(int row, int col, String message) {
        this.row = row;
        this.column = col;
        this.message = message;
    }
    

    @Override
    public String getMessage() {
        return "Problem with the board-cell with coordinates: (" + row + ", " + column + "). The problem is: " + message;
    }
    
}

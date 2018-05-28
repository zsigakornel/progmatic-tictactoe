package com.progmatic.tictactoeexam.interfaces;

import com.progmatic.tictactoeexam.Cell;
import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.exceptions.CellException;
import java.util.List;

/**
 * @author pappgergely
 */
public interface Board {
    /**
     * Returns the Cell's content at rowIdx, colIdx;
     * @param rowIdx
     * @param colIdx
     * @return
     * @throws CellException if rowIdx or colIdx points to a non-existent index.
     */
    PlayerType getCell(int rowIdx, int colIdx) throws CellException;
    
    /**
     * Puts a cell to the board.
     * @param cell
     * @throws CellException if rowIdx or colIdx points to a non-existent index or if the cell is non empty.
     */
    void put(Cell cell) throws CellException;
    
    /**
     * Determines if player p has won.
     * A player wins if she has 3 marks in the board next to each other
     * in a horizontal, vertical or diagonal direction.
     * @param p
     * @return true if p has 3 marks in the board next to each other, false otherwise.
     */
    boolean hasWon(PlayerType p);
    
    /**
     * Returns a list of the cells not yet occupied by any player.
     * @return a list of the cells not yet occupied by any player. 
     * If there are no more empty cells on the board returns an empty list.
     */
    List<Cell> emptyCells();
}
